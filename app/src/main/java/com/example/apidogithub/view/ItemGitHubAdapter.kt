package com.example.apidogithub.view

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.apidogithub.databinding.ItemRepoBinding
import com.example.apidogithub.models.ItemGitHub
import com.example.apidogithub.models.ItemGitHubModel

class ItemGitHubAdapter (val items: MutableList<ItemGitHubModel>): RecyclerView.Adapter<ItemGitHubAdapter.ItemGitHubViewHolder>() {



    class ItemGitHubViewHolder(
        private val binding: ItemRepoBinding
    ): RecyclerView.ViewHolder(binding.root){

        fun bind(items:ItemGitHubModel)
        {
            binding.name.text = items.name
            binding.description.text = items.description
            binding.stars.text = items.stargazers_count.toString()
            binding.forks.text = items.forks_count.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemGitHubViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemRepoBinding.inflate(layoutInflater,parent,false)
        return ItemGitHubViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemGitHubViewHolder, position: Int) {
        holder.bind(this.items[position])
    }

    override fun getItemCount(): Int {
        return this.items.size
    }
}