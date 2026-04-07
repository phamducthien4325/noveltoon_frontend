package com.example.noveltoon.di

import com.example.noveltoon.data.repository.AuthRepositoryImpl
import com.example.noveltoon.data.repository.ChapterRepositoryImpl
import com.example.noveltoon.data.repository.HashtagRepositoryImpl
import com.example.noveltoon.data.repository.NovelRepositoryImpl
import com.example.noveltoon.data.repository.UserRepositoryImpl
import com.example.noveltoon.domain.repository.AuthRepository
import com.example.noveltoon.domain.repository.ChapterRepository
import com.example.noveltoon.domain.repository.HashtagRepository
import com.example.noveltoon.domain.repository.NovelRepository
import com.example.noveltoon.domain.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindHashtagRepository(
        impl: HashtagRepositoryImpl
    ): HashtagRepository

    @Binds
    abstract fun bindNovelRepository(
        impl: NovelRepositoryImpl
    ): NovelRepository

    @Binds
    abstract fun bindAuthRepository(
        impl: AuthRepositoryImpl
    ): AuthRepository

    @Binds
    abstract fun bindUserRepository(
        impl: UserRepositoryImpl
    ): UserRepository

    @Binds
    abstract fun bindChapterRepository(
        impl: ChapterRepositoryImpl
    ): ChapterRepository
}