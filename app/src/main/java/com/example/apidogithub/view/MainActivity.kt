package com.example.apidogithub.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.apidogithub.R
import com.example.apidogithub.databinding.ActivityMainBinding
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apidogithub.data.RepositoryError
import com.example.apidogithub.data.RepositoryResponse
import com.example.apidogithub.data.RetrofitService
import com.example.apidogithub.data.Source
import com.example.apidogithub.data.repository.ItemGitHubService
import com.example.apidogithub.models.ItemGitHubModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var recyclerView : ItemGitHubAdapter

    private val viewmodel :ItemGitHubViewModel by viewModels (
         factoryProducer={  ItemGitHubViewModelFactory ()    }
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        initRecyclerView()
    }
    private fun initRecyclerView(){

        val service = RetrofitService.instance
            .create(ItemGitHubService::class.java)
            .getRandomItemsGitHub()

        service.enqueue(object : Callback<MutableList<ItemGitHubModel>> {
            override fun onResponse(
                call: Call<MutableList<ItemGitHubModel>>, response: Response<MutableList<ItemGitHubModel>>){
                if(response.isSuccessful){

                    binding.repo.apply {
                        layoutManager = LinearLayoutManager(this@MainActivity)
                        adapter = ItemGitHubAdapter(response.body()!!)
                    }
                }
            }
            override fun onFailure(call: Call<MutableList<ItemGitHubModel>>, t: Throwable) {
                t.printStackTrace()
                Log.e("error", t.message.toString())
            }
        })
    }
}