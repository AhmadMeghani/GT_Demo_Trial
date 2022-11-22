package com.meghani.gtdemo.presentation.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.meghani.gtdemo.databinding.FragmentChannelBinding
import com.meghani.gtdemo.presentation.adapters.ChannelRecyclerViewAdapter
import com.meghani.gtdemo.presentation.viewmodel.AppViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ChannelFragment : Fragment() {
    private lateinit var binding: FragmentChannelBinding

    private val viewModel: AppViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentChannelBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getChannels().observe(viewLifecycleOwner) {
            binding.channelRv.layoutManager = GridLayoutManager(activity, 3)
            val adapter = ChannelRecyclerViewAdapter(it) { packageName, url ->
                openApplicationOrUrl(packageName, url)
            }
            binding.channelRv.adapter = adapter
        }
    }

    private fun openApplicationOrUrl(packageName: String, url: String) {
        var intent = requireContext().packageManager.getLaunchIntentForPackage(packageName)
        if (intent == null) {
            intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
        }

        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        requireContext().startActivity(intent)
    }


}
