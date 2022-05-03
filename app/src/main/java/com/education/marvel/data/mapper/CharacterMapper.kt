package com.education.marvel.data.mapper

import com.education.marvel.data.entity.CharacterEntity
import com.education.marvel.data.entity.CharacterNetwork
import com.education.marvel.data.entity.NetworkImage
import com.education.marvel.data.utils.CharacterDetailsBuilder
import com.education.marvel.domain.entity.Character
import com.education.marvel.domain.entity.Image

fun CharacterNetwork.toCharacter(detailsBuilder: CharacterDetailsBuilder, page: Int) = Character(
    id = id,
    name = name,
    description = description,
    modified = modified,
    resUrl = resUrl,
    thumbnail = thumbnail?.map(),
    details = detailsBuilder.build(this),
    page = page
)

fun CharacterEntity.toCharacter() = Character(
    id = id,
    name = name,
    description = description,
    modified = modified,
    resUrl = resUrl,
    thumbnail = thumbnail,
    details = details,
    page = page
)

fun Character.toEntity(page: Int) = CharacterEntity(
    id = id,
    name = name,
    description = description,
    modified = modified,
    resUrl = resUrl,
    thumbnail = thumbnail,
    details = details,
    page = page
)

fun NetworkImage.map() = Image(path, extension)
