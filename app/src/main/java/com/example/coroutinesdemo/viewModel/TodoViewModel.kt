package com.example.coroutinesdemo.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.coroutinesdemo.repository.ToDoRepository
import kotlinx.coroutines.Dispatchers

class TodoViewModel : ViewModel() {
    val repository = ToDoRepository()


    fun getFirstTodo() = liveData(Dispatchers.IO) {
        val firstTodo = repository.getTodo(1)

        emit(firstTodo)
    }
}