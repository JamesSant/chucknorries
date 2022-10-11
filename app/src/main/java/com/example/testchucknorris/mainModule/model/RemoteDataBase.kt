package com.example.testchucknorris.mainModule.model

import com.example.testchucknorris.common.Constants
import com.example.testchucknorris.common.dataAccess.Service
import com.example.testchucknorris.common.entidies.DetailJoker
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RemoteDataBase {
    private val retrofit = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val service = retrofit.create(Service::class.java)

    suspend fun getCategories(): List<String> = withContext(Dispatchers.IO) {
        service.getCategories()
    }

    suspend fun getDetailJoker(category: String): DetailJoker = withContext(Dispatchers.IO) {
        service.getDetailJoker(category)
    }
}