package com.education.marvel.di

import com.education.marvel.AppConstants.BASE_URL
import com.education.marvel.AppConstants.THUMBNAIL_PATH
import com.education.marvel.BuildConfig
import com.education.marvel.data.network.AuthInterceptor
import com.education.marvel.data.network.MarvelApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Module(includes = [NetworkBindingsModule::class])
object NetworkModule {

    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor().setLevel(
        if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
        else HttpLoggingInterceptor.Level.NONE
    )

    @Provides
    fun provideOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor,
        authInterceptor: AuthInterceptor
    ): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(authInterceptor)
        .addInterceptor(loggingInterceptor)
        .build()

    @Provides
    fun provideRetrofit(
        client: OkHttpClient
    ): Retrofit = Retrofit.Builder()
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    @Provides
    fun provideMarvelApi(retrofit: Retrofit): MarvelApi = retrofit.create(MarvelApi::class.java)

}