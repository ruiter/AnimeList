package com.ruiter.animelist.di

import com.ruiter.animelist.data.repository.AnimeListRepository
import com.ruiter.animelist.data.repository.AnimeListRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindAnimeListRepository(animeListRepositoryImpl: AnimeListRepositoryImpl): AnimeListRepository
}