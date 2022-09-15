package com.ruiter.animelist.presentation.animelist

import com.ruiter.animelist.presentation.model.Animes

data class AnimeListState(
    val isLoading: Boolean = false,
    val animes: List<Animes> = emptyList()
)