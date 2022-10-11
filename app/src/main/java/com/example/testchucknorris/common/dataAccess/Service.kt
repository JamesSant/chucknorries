package com.example.testchucknorris.common.dataAccess

import com.example.testchucknorris.common.Constants
import com.example.testchucknorris.common.entidies.DetailJoker
import retrofit2.http.GET
import retrofit2.http.Query

interface Service {
    @GET(Constants.BASE_URL + Constants.URL_CATEGORIES)
    suspend fun getCategories(): List<String>

    @GET(Constants.BASE_URL + Constants.URL_DETAIL)
    suspend fun getDetailJoker(@Query("category")category: String): DetailJoker
}