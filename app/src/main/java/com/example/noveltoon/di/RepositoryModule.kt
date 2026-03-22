package com.example.noveltoon.di

import com.example.noveltoon.data.remote.api.NovelApi
import com.example.noveltoon.data.repository.NovelRepositoryImpl
import com.example.noveltoon.domain.repository.NovelRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideNovelRepository(
        api: NovelApi
    ): NovelRepository {
        return NovelRepositoryImpl(api)
//        return FakeNovelRepository()
    }
}