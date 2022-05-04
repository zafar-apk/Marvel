package com.education.marvel.presenter.util

import com.education.domain.AppConstants

fun com.education.domain.entity.Image.buildDetailImageUrl() =
    "$path/${AppConstants.THUMBNAIL_MAIN_PATH}.$extension"

fun com.education.domain.entity.Image.buildListItemUrl() =
    "$path/${AppConstants.THUMBNAIL_PATH}.$extension"