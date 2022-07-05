package com.example.apidogithub.data.repository


import com.example.apidogithub.data.RepositoryListener
import com.example.apidogithub.models.ItemGitHub
import com.example.apidogithub.models.ItemGitHubModel


class ItemGitHubRepository (private val remoteDataSource: ItemGitHubRemoteDataSource) {

        fun getItemGitHub(listener: RepositoryListener<ItemGitHubModel>) {
            //this.remoteDataSource.getRandomItemGitHub(listener)
        }
}