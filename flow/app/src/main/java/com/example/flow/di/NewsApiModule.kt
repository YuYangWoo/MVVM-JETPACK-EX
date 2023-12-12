package com.example.flow.di

import com.example.flow.data.api.NewsApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NewsApiModule {
    val baseUrl = "https://newsapi.org"

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): NewsApiService = retrofit.create(NewsApiService::class.java)

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit = Retrofit.Builder().baseUrl(baseUrl).client(OkHttpClient()).addConverterFactory(GsonConverterFactory.create()).build()
}
