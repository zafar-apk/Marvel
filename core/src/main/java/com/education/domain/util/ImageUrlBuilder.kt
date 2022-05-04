package com.education.domain.util

import com.education.domain.AppConstants
import com.education.domain.entity.Image

fun Image.buildDetailImageUrl() = "$path/${AppConstants.THUMBNAIL_MAIN_PATH}.$extension"

fun Image.buildListItemUrl() = "$path/${AppConstants.THUMBNAIL_PATH}.$extension"