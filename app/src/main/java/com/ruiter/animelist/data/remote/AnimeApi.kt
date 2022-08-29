package com.ruiter.animelist.data.remote

import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Query

interface AnimeApi {

    @GET("/anime")
    suspend fun getAnimeList(@Query("page") page: Int, @Query("limit") limit: Int): ResponseBody
}