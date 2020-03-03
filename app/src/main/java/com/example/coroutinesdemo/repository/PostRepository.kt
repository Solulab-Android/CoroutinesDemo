package com.example.coroutinesdemo.repository

import com.example.coroutinesdemo.model.Post
import com.example.coroutinesdemo.network.ApiClient
import com.example.coroutinesdemo.utils.Resource
import com.example.coroutinesdemo.utils.ResponseHandler
import java.lang.Exception

class PostRepository {
    val client = ApiClient.getApiClient()
    val responseHandler = ResponseHandler()

    suspend fun getAllPost(): Resource<List<Post>?> {
        return try {
            responseHandler.handleSuccess(client.getPost())
        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }
}