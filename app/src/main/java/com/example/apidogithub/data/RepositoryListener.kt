package com.example.apidogithub.data

interface RepositoryListener<T> {

    fun onResponse(response: RepositoryResponse<T>)

    fun onError(repositoryError: RepositoryError)

}