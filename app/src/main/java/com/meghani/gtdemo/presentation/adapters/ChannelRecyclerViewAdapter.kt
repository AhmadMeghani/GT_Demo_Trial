package com.meghani.gtdemo.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.meghani.gtdemo.data.model.Channel
import com.meghani.gtdemo.databinding.AppItemChannelBinding

class ChannelRecyclerViewAdapter(
    private val dataSet: List<Channel>,
    private val onItemClick: (String, String) -> Unit
) :
    RecyclerView.Adapter<ChannelRecyclerViewAdapter.AdapterVH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterVH {
        return AdapterVH(
            AppItemChannelBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: AdapterVH, position: Int) {
        holder.bind(dataSet[position], onItemClick)
    }

    override fun getItemCount(): Int = dataSet.size


    class AdapterVH(private val binding: AppItemChannelBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(channel: Channel, onItemClick: (String, String) -> Unit) {
            binding.data = channel

            binding.root.setOnClickListener {
                onItemClick(channel.package_name_android, channel.url)
            }
        }
    }

}


