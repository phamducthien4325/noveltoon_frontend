package com.example.noveltoon.di

import com.example.noveltoon.data.remote.api.HashtagApi
import com.example.noveltoon.data.remote.api.NovelApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8080/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideNovelApi(retrofit: Retrofit): NovelApi {
        return retrofit.create(NovelApi::class.java)
    }

    @Provides
    @Singleton
    fun provideHashtagApi(retrofit: Retrofit): HashtagApi {
        return retrofit.create(HashtagApi::class.java)
    }
}