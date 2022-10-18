package com.example.android.roomwordssample.framework.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android.roomwordssample.R
import com.example.android.roomwordssample.applicaiton.adapters.WordListAdapter
import com.example.android.roomwordssample.applicaiton.repositories.WordRepository
import com.example.android.roomwordssample.applicaiton.viewmodels.UsersViewModel
import com.example.android.roomwordssample.applicaiton.viewmodels.WordViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class UsersActivity : AppCompatActivity() {

    @Inject lateinit var repository: WordRepository

    private val viewModel: UsersViewModel by viewModels {
        WordViewModelFactory(repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_users)

        val recyclerView = findViewById<RecyclerView>(R.id.users_recyclerview)
        val adapter = WordListAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}