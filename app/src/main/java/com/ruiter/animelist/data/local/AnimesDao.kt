package com.ruiter.animelist.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface AnimesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAnimeList(animes: List<AnimeListEntity>)

    @Query("SELECT * FROM animeListEntity WHERE page = :page_")
    suspend fun getAnimeList(page_: Int): List<AnimeListEntity>

    @Query("DELETE FROM animelistentity")
    suspend fun clearLocalAnimeListEntity()
}