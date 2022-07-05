package com.example.apidogithub.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.apidogithub.data.repository.ItemGitHubRemoteDataSource
import com.example.apidogithub.data.repository.ItemGitHubRepository

class ItemGitHubViewModelFactory : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        val remoteDataSource = ItemGitHubRemoteDataSource()
        val repository = ItemGitHubRepository(remoteDataSource)
        return ItemGitHubViewModel(repository) as T
    }
}