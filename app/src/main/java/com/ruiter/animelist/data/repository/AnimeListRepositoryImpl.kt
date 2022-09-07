package com.ruiter.animelist.data.repository

import com.ruiter.animelist.data.local.AnimesDatabase
import com.ruiter.animelist.data.mapper.toAnimesList
import com.ruiter.animelist.data.mapper.toAnimesListEntity
import com.ruiter.animelist.data.mapper.toLocalAnimes
import com.ruiter.animelist.data.remote.AnimeApi
import com.ruiter.animelist.presentation.model.Animes
import com.ruiter.animelist.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class AnimeListRepositoryImpl @Inject constructor(val animeApi: AnimeApi, val db: AnimesDatabase) :
    AnimeListRepository {
    private val dao = db.dao

    override suspend fun getAnimeList(
        page: Int,
        fetchFromRemote: Boolean
    ): Flow<Resource<List<Animes>>> {
        return flow {
            emit(Resource.Loading(true))
            val localAnimes = dao.getAnimeList(page)
            emit(Resource.Success(
                data = localAnimes.map { it.toLocalAnimes() }
            ))

            val isDbEmpty = localAnimes.isEmpty()
            val shouldLoadFromLocal = !isDbEmpty && !fetchFromRemote

            if (shouldLoadFromLocal) {
                emit(Resource.Loading(false))
                return@flow
            }

            val responseResult = try {
                val result = animeApi.getAnimeList(page, PAGE_LIMIT)
                result.toAnimesList()
            } catch (e: IOException) {
                e.printStackTrace()
                emit(Resource.Error("Something happened when trying to load the data"))
                null
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(Resource.Error("Something happened when trying to load the data"))
                null
            }

            responseResult?.let { animesList ->
                dao.clearLocalAnimeListEntity()
                dao.insertAnimeList(animesList.map { it.toAnimesListEntity(page) })

                emit(Resource.Success(data = animesList))
                emit(Resource.Loading(false))
            }
        }

    }

    companion object {
        const val PAGE_LIMIT = 20
    }
}