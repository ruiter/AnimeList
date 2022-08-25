package com.ruiter.animelist.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class AnimeListEntity(
    val title: String,
    val imageUrl: String,
    val rating: String,
    val score: Float,
    @PrimaryKey val id: Int? = null
)
