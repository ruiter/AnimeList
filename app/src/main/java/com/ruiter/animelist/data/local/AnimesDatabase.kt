package com.ruiter.animelist.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [AnimeListEntity::class],
    version = 1
)
abstract class AnimesDatabase : RoomDatabase(){
    abstract val dao: AnimesDao
}