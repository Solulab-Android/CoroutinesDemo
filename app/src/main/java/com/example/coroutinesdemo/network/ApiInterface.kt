package com.example.coroutinesdemo.network

import com.example.coroutinesdemo.model.Post
import com.example.coroutinesdemo.model.Todo
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    @GET("todos/{id}")
    suspend fun getTodo(@Path("id") todoId: Int): Todo

    @GET("posts")
    suspend fun getPost(): List<Post>
}