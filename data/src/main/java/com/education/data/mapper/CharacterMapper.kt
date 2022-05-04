package com.education.data.mapper


import com.education.data.entity.CharacterEntity
import com.education.data.utils.CharacterDetailsBuilder
import com.education.domain.entity.Character
import com.education.domain.entity.Image
import com.education.network.entity.NetworkImage
import com.education.network.entity.character.CharacterNetwork

fun CharacterNetwork.toCharacter(
    detailsBuilder: CharacterDetailsBuilder, page: Int
) = Character(
    id = id,
    name = name,
    description = description,
    modified = modified,
    thumbnail = thumbnail?.map(),
    details = detailsBuilder.build(this),
    page = page
)

fun CharacterEntity.toCharacter() = Character(
    id = id,
    name = name,
    description = description,
    modified = modified,
    thumbnail = thumbnail,
    details = details,
    page = page
)

fun Character.toEntity(page: Int) = CharacterEntity(
    id = id,
    name = name,
    description = description,
    modified = modified,
    thumbnail = thumbnail,
    details = details,
    page = page
)

fun NetworkImage.map() = Image(path, extension)
