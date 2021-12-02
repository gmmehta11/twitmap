package com.gmm.twittmap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gmm.twittmap.adapter.CustomAdapter
import com.gmm.twittmap.model.Data
import com.gmm.twittmap.model.Twitt
import com.gmm.twittmap.viewmodel.TwitViewModel

class MainActivity : AppCompatActivity(){
    private lateinit var recyclerView: RecyclerView
    private lateinit var customAdapter: CustomAdapter
    private lateinit var twitViewModel:TwitViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("MainActivity", "My 'token' is: " + BuildConfig.TOKEN);
        initUI()
        twitViewModel = ViewModelProvider(this)[TwitViewModel::class.java]
        twitViewModel.getTwit()
        twitViewModel.responseLiveData.observe(this,{
            customAdapter.setTwit(it.data as ArrayList<Data>)

        })
    }

    private fun initUI(){
        recyclerView = findViewById(R.id.recyclerView)
        customAdapter = CustomAdapter(this@MainActivity, arrayListOf<Data>())
        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager=LinearLayoutManager(this@MainActivity)
            adapter=customAdapter
        }
    }
}