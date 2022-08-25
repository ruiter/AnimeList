package com.ruiter.animelist.data.remote.dto

import com.squareup.moshi.Json

data class AnimeListDto(@field:Json(name = "data") val data: List<AnimesDto>)
