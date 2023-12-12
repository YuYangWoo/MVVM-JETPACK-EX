package com.example.flow.data.api

import com.example.flow.BuildConfig
import com.example.flow.data.model.News
import retrofit2.http.GET

interface NewsApiService {
    @GET("/v2/top-headlines?country=kr&apiKey=${BuildConfig.NEWS_API_KEY}")
    suspend fun getNews(): News
}
