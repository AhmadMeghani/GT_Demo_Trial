package com.meghani.gtdemo

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.meghani.gtdemo.databinding.FragmentSocialBinding
import com.meghani.gtdemo.presentation.viewmodel.AppViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SocialFragment : Fragment() {
    private lateinit var binding: FragmentSocialBinding

    private val viewModel: AppViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentSocialBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getSocials().observe(viewLifecycleOwner) {
            binding.socialRv.layoutManager = GridLayoutManager(activity, 3)
            val adapter = SocialRecyclerViewAdapter(it) { packageName, url ->
                openApplicationOrUrl(packageName, url)
            }
            binding.socialRv.adapter = adapter
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