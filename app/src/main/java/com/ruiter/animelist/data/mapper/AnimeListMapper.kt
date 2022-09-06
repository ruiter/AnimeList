package com.ruiter.animelist.data.mapper

import com.ruiter.animelist.data.local.AnimeListEntity
import com.ruiter.animelist.data.remote.dto.AnimeListDto
import com.ruiter.animelist.data.remote.dto.AnimesDto
import com.ruiter.animelist.data.remote.dto.ImagesDto
import com.ruiter.animelist.data.remote.dto.JpgDto
import com.ruiter.animelist.presentation.model.AnimeList
import com.ruiter.animelist.presentation.model.Animes
import com.ruiter.animelist.presentation.model.Images
import com.ruiter.animelist.presentation.model.Jpg

fun AnimeListEntity.toLocalAnimes(): Animes {
    return Animes(images = Images(Jpg(imageUrl)), title = title, rating = rating, score = score)
}

fun Animes.toAnimesListEntity(page: Int): AnimeListEntity {
    return AnimeListEntity(page = page, title = title, imageUrl = images.jpg.imageUrl, rating = rating, score = score)
}

fun AnimeListDto.toAnimesList(): List<Animes> {
    return data.map { it.toAnimes() }
}
fun AnimesDto.toAnimes(): Animes {
    return Animes(images.toImages(), title, rating, score)
}

fun ImagesDto.toImages(): Images {
    return Images(jpg = jpg.toJpg())
}

fun JpgDto.toJpg(): Jpg {
    return Jpg(imageUrl = imageUrl)
}

