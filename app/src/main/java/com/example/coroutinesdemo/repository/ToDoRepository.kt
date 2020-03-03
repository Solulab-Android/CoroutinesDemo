package com.example.coroutinesdemo.repository

import com.example.coroutinesdemo.network.ApiClient

class ToDoRepository {
    val client = ApiClient.getApiClient()

    suspend fun getTodo(id: Int) = client.getTodo(id)
}