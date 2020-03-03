package com.example.coroutinesdemo.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.coroutinesdemo.model.Post
import com.example.coroutinesdemo.repository.PostRepository
import com.example.coroutinesdemo.utils.Resource
import kotlinx.coroutines.Dispatchers

class PostViewModel : ViewModel() {
    val repository = PostRepository()

    val allPost: LiveData<Resource<List<Post>?>> = liveData(Dispatchers.IO) {
        emit(Resource.loading(null))
        emit(repository.getAllPost())
        emit(Resource.completed(null))
    }
}