package com.education.domain.repository

import com.education.domain.entity.Character

interface CharacterRepository {

    suspend fun getById(id: Int): Character

}