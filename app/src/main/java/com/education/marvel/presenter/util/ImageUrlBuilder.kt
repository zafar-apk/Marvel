package com.education.marvel.presenter.util

import com.education.marvel.AppConstants
import com.education.marvel.domain.entity.Image

fun Image.buildDetailImageUrl() = "$path/${AppConstants.THUMBNAIL_MAIN_PATH}.$extension"

fun Image.buildListItemUrl() = "$path/${AppConstants.THUMBNAIL_PATH}.$extension"