package com.example.apidogithub.models

import com.google.gson.annotations.SerializedName

data class ItemGitHubModel (
    @SerializedName("name")
    var name: String,
    @SerializedName("description")
    var description: String,
    @SerializedName("stargazers_count")
    var stargazers_count: Int,
    @SerializedName("forks_count")
    var forks_count: Int
)