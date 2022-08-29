package com.ruiter.animelist.data.repository

import com.ruiter.animelist.data.local.AnimesDatabase
import com.ruiter.animelist.data.remote.AnimeApi
import com.ruiter.animelist.presentation.model.AnimeList
import com.ruiter.animelist.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AnimeListRepositoryImpl @Inject constructor(val animeApi: AnimeApi, val db: AnimesDatabase) :
    AnimeListRepository {

    override suspend fun getAnimeList(
        page: Int,
        fetchFromRemote: Boolean
    ): Flow<Resource<List<AnimeList>>> {
        TODO("Not yet implemented")
    }
}