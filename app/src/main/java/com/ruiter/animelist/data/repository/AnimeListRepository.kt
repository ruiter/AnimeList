package com.ruiter.animelist.data.repository

import com.ruiter.animelist.presentation.model.AnimeList
import com.ruiter.animelist.util.Resource
import kotlinx.coroutines.flow.Flow

interface AnimeListRepository {

    suspend fun getAnimeList(page: Int, fetchFromRemote: Boolean): Flow<Resource<List<AnimeList>>>
}