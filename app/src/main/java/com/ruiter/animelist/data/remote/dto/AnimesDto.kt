package com.ruiter.animelist.data.remote.dto

import com.squareup.moshi.Json

data class AnimesDto(
    @field:Json(name = "images") val images: ImagesDto,
    @field:Json(name = "title") val title: String,
    @field:Json(name = "rating") val rating: String?,
    @field:Json(name = "score") val score: Float?
)
