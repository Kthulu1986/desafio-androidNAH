package com.example.apidogithub.data.repository

import com.example.apidogithub.data.*
import com.example.apidogithub.models.ItemGitHubModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ItemGitHubRemoteDataSource {

    /*fun getRandomItemGitHub (listener: RepositoryListener<ItemGitHubModel>) {

        val service = RetrofitService.instance
            .create(ItemGitHubService::class.java)
            .getRandomItemsGitHub()

        service.enqueue(object : Callback<ItemGitHubModel> {
            override fun onResponse(
                call: Call<ItemGitHubModel>,
                response: Response<ItemGitHubModel>
            ) {
                val itemGitHub = response.body()
                if (response.isSuccessful && itemGitHub != null) {
                    listener.onResponse(
                        RepositoryResponse(
                            data = itemGitHub,
                            source = Source.REMOTE
                        )
                    )
                } else {
                    listener.onError(
                        RepositoryError(
                            message = "El servidor rechazó la solicitud",
                            code = response.code(),
                            source = Source.REMOTE
                        )
                    )
                }
            }

            override fun onFailure(call: Call<ItemGitHubModel>, t: Throwable) {
                listener.onError(
                    RepositoryError(
                        message = t.message ?: "Error inesperado",
                        code = -1,
                        source = Source.REMOTE
                    )
                )
            }
        })
    }*/
}