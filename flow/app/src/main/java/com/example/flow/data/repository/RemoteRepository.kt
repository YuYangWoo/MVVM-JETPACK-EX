package com.example.flow.data.repository

import com.example.flow.data.api.NewsApiService
import com.example.flow.data.model.News
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteRepository @Inject constructor(private val newsApiService: NewsApiService) {
     fun requestNews(): Flow<News> = flow {
         emit(newsApiService.getNews())
     }.flowOn(Dispatchers.IO)
}
