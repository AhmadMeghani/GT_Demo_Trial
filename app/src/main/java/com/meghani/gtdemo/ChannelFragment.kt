package com.meghani.gtdemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.meghani.gtdemo.databinding.FragmentChannelBinding
import com.meghani.gtdemo.databinding.FragmentSocialBinding
import com.meghani.gtdemo.presentation.viewmodel.AppViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.nio.channels.Channel
import javax.inject.Inject

@AndroidEntryPoint
class ChannelFragment() : Fragment() {
    lateinit var binding: FragmentChannelBinding

    private val viewModel: AppViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentChannelBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        try {
//            val responseLiveData = viewModel.getChannels()
            viewModel.getSocials().observe(viewLifecycleOwner) {
                binding.text.text = it.toString()
            }
            /*responseLiveData.observe(viewLifecycleOwner) {
                it.isNotEmpty()
            }*/
        } catch (e: Exception) {
        }



    }


}
