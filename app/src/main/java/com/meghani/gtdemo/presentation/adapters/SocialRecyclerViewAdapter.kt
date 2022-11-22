package com.meghani.gtdemo.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.meghani.gtdemo.data.model.Social
import com.meghani.gtdemo.databinding.AppItemBinding

class SocialRecyclerViewAdapter(private val dataSet: List<Social>, private val onItemClick: (String, String) -> Unit) :
    RecyclerView.Adapter<SocialRecyclerViewAdapter.AdapterVH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterVH {
        return AdapterVH(AppItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: AdapterVH, position: Int) {
        holder.bind(dataSet[position], onItemClick)
    }

    override fun getItemCount(): Int = dataSet.size


    class AdapterVH(private val binding: AppItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(social: Social, onItemClick: (String, String) -> Unit) {
            binding.data = social

            binding.root.setOnClickListener {
                onItemClick(social.package_name_android, social.url)
            }
        }
    }

}


