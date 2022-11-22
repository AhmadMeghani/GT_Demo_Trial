package com.meghani.gtdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.meghani.gtdemo.presentation.viewmodel.AppViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel : AppViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        try {
            val responseLiveData = viewModel.getChannels()
            viewModel.getSocials().observe(this) {

            }
            responseLiveData.observe(this) {
                it.isNotEmpty()
            }
        } catch (e: Exception) {
        }
    }
}