package com.meghani.gtdemo

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.meghani.gtdemo.data.model.Social
import com.meghani.gtdemo.databinding.FragmentSocialBinding
import com.meghani.gtdemo.presentation.viewmodel.AppViewModel

class SocialFragment() : Fragment() {
    lateinit var binding: FragmentSocialBinding

    private val viewModel: AppViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentSocialBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        try {
            val responseLiveData = viewModel.getChannels()
            responseLiveData.observe(viewLifecycleOwner) {
                binding.text.text = it.toString()
            }
            /*responseLiveData.observe(viewLifecycleOwner) {
                it.isNotEmpty()
            }*/
        } catch (e: Exception) {
        }
    }

    override fun onStart() {
        super.onStart()
        try {
            val responseLiveData = viewModel.getChannels()
            responseLiveData.observe(viewLifecycleOwner) {
                binding.text.text = it.toString()
            }
            /*responseLiveData.observe(viewLifecycleOwner) {
                it.isNotEmpty()
            }*/
        } catch (e: Exception) {
        }
    }
}