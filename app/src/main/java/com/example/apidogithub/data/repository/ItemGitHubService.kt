package com.example.apidogithub.data.repository

import com.example.apidogithub.models.ItemGitHubModel
import retrofit2.Call
import retrofit2.http.GET

interface ItemGitHubService {

    @GET("/search/repositories?q=language:Java&sort=stars&page=1")
    fun getRandomItemsGitHub(): Call<MutableList<ItemGitHubModel>>
}