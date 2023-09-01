package com.example.viewmodeltest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import kotlin.concurrent.fixedRateTimer

class MainActivity : AppCompatActivity() {
    private val userViewModel by lazy{
        ViewModelProviders.of(this).get(UserViewModel::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userAdapter = UserAdapter()

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = userAdapter

        userViewModel.getListUsers().observe(this, Observer { it?.let{userAdapter.reftreshUsers(it)} })

        val refreshBUtton = findViewById<Button>(R.id.refreshButton)
        refreshBUtton.setOnClickListener { userViewModel.updateListUsers() }
    }
}