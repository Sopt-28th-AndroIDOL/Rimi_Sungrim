package com.example.be_sopt_seminar.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.be_sopt_seminar.data.FollowingUserInfo
import com.example.be_sopt_seminar.data.RepositoryInfo
import com.example.be_sopt_seminar.databinding.ItemFollowingUserBinding
import com.example.be_sopt_seminar.databinding.ItemRepositoryBinding

class RepositoryAdapter : RecyclerView.Adapter<RepositoryAdapter.RepositoryViewHolder>() {

    val repoList = mutableListOf<RepositoryInfo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryAdapter.RepositoryViewHolder {
        val binding = ItemRepositoryBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return RepositoryAdapter.RepositoryViewHolder(
            binding
        )
    }

    override fun getItemCount(): Int  = repoList.size

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        holder.onBind(repoList[position])
    }

    class RepositoryViewHolder(
        private val binding: ItemRepositoryBinding
        ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(repositoryInfo: RepositoryInfo){
            binding.homeRepoName.text = repositoryInfo.repositoryName
            binding.homeRepoDescription.text = repositoryInfo.repositoryDescription
            binding.homeRepoLanguage.text = repositoryInfo.repositoryLanguage
        }
    }
}