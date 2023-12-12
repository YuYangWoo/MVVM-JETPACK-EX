package com.example.flow.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.flow.data.model.Article
import com.example.flow.databinding.HolderNewsBinding
import com.example.flow.ui.view.fragment.MainNewsFragmentDirections
import dagger.hilt.android.scopes.FragmentScoped
import javax.inject.Inject

@FragmentScoped
class NewsAdapter @Inject constructor() : ListAdapter<Article, NewsAdapter.NewsHolder>(DiffNews) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsHolder {
        return NewsHolder(HolderNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: NewsHolder, position: Int) {
        Log.d("TAG", getItem(position).hashCode().toString())
        holder.bind(getItem(position))
    }

    inner class NewsHolder(private val binding: HolderNewsBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                try {
                    val direction = MainNewsFragmentDirections.actionMainNewsFragmentToNewsInformationFragment(getItem(adapterPosition))
                    binding.root.findNavController().navigate(direction)
                } catch (e: Exception) {
                    Log.d("TAG", e.message.toString())
                }

            }
        }
        fun bind(article: Article) {
            binding.article = article
        }
    }

    object DiffNews : DiffUtil.ItemCallback<Article>() {
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            Log.d("TAG", oldItem.hashCode().toString() + "newITem is ${newItem.hashCode()}")

            return oldItem.hashCode() == newItem.hashCode()
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }
    }

}

