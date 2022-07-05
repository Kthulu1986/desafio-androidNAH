package com.example.apidogithub.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.apidogithub.data.RepositoryError
import com.example.apidogithub.data.RepositoryListener
import com.example.apidogithub.data.RepositoryResponse
import com.example.apidogithub.data.repository.ItemGitHubRepository
import com.example.apidogithub.models.ItemGitHub
import com.example.apidogithub.models.ItemGitHubModel

class ItemGitHubViewModel (private val repository: ItemGitHubRepository) : ViewModel(){

    val itemsLiveData = MutableLiveData<ItemGitHubModel?>(null)
    val loading = MutableLiveData<Boolean>(false)
    val error = MutableLiveData<String?>(null)

    fun getItems(){
        error.value = null
        itemsLiveData.value = null
        loading.value = true

        repository.getItemGitHub(object: RepositoryListener<ItemGitHubModel>{

            override fun onResponse(response: RepositoryResponse<ItemGitHubModel>) {
                val itemGitHubResponse = response.data

                loading.value = false
                error.value = null
                itemsLiveData.value = itemGitHubResponse
            }

            override fun onError(repositoryError: RepositoryError) {
                val message = "${repositoryError.message} (code: ${repositoryError.code})"

                loading.value = false
                error.value = message
                itemsLiveData.value = null
            }
        })
    }
}