package com.example.testchucknorris.mainModule.model

import com.example.testchucknorris.common.entidies.DetailJoker

class MainRepository {

    private val remoteDataBase = RemoteDataBase()

    suspend fun invokeCategories(): List<String> = remoteDataBase.getCategories()

    suspend fun invokeDetailJoker(category: String): DetailJoker =
        remoteDataBase.getDetailJoker(category)
}