package com.education.data.repository

import com.education.domain.repository.CharacterRepository
import com.education.domain.source.LocalDataSource
import javax.inject.Inject


class CharacterRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource
) : CharacterRepository {

    override suspend fun getById(id: Int) = localDataSource.getById(id)

}
