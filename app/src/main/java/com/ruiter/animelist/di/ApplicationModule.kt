package com.ruiter.animelist.di

import android.app.Application
import androidx.room.Room
import com.ruiter.animelist.data.local.AnimesDatabase
import com.ruiter.animelist.data.remote.AnimeApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {

    @Provides
    @Singleton
    fun provideAnimeApi(): AnimeApi {
        return Retrofit.Builder()
            .baseUrl("https://api.jikan.moe/v4")
            .addConverterFactory(MoshiConverterFactory.create())
            .client(OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }).build())
            .build()
            .create()
    }

    @Provides
    @Singleton
    fun provideAnimeDatabase(app: Application): AnimesDatabase {
        return Room.databaseBuilder(
            app,
            AnimesDatabase::class.java,
            "animedb.db"
        ).build()
    }
}