package com.example.coroutinesdemo

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coroutinesdemo.databinding.ItemPostBinding
import com.example.coroutinesdemo.model.Post
import com.example.coroutinesdemo.utils.Resource
import com.example.coroutinesdemo.utils.Status
import com.example.coroutinesdemo.utils.hide
import com.example.coroutinesdemo.utils.show
import com.example.coroutinesdemo.viewModel.PostViewModel
import com.example.coroutinesdemo.viewModel.TodoViewModel
import com.github.nitrico.lastadapter.LastAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var todoViewModel: TodoViewModel
    lateinit var postViewModel: PostViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
        showData()
    }

    private fun init() {
        recPost.layoutManager = LinearLayoutManager(this)
//        todoViewModel = ViewModelProviders.of(this).get(TodoViewModel::class.java)
        postViewModel = ViewModelProviders.of(this).get(PostViewModel::class.java)
    }

    private fun showData() {
//        todoViewModel.getFirstTodo()
//            .observe(this, androidx.lifecycle.Observer { tvTitle.text = it.title })


        val observer = Observer<Resource<List<Post>?>> {
            when (it.status) {
                Status.SUCCESS -> {
                    val postList = it

                    LastAdapter(postList.data.orEmpty(), BR.post)
                        .map<Post, ItemPostBinding>(R.layout.item_post)
                        .into(recPost)
                }

                Status.ERROR -> {
                    Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                }

                Status.LOADING -> {
                    progressBar.show()
                }

                Status.COMPLETED -> {
                    progressBar.hide()
                }
            }
        }
        postViewModel.allPost.observe(this, observer)
    }
}
