package com.example.testchucknorris

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.testchucknorris.databinding.ActivityMainJokerDetailBinding
import com.example.testchucknorris.mainModule.viewModel.JokerViewModel

class MainActivityJokerDetail : AppCompatActivity() {

    private lateinit var binding: ActivityMainJokerDetailBinding
    private lateinit var jokerViewModel: JokerViewModel
    private var category = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainJokerDetailBinding.inflate(layoutInflater)
        jokerViewModel = ViewModelProvider(this)[JokerViewModel::class.java]
        setContentView(binding.root)

        setUpObservers()
        getBudle()
    }

    private fun getBudle() {
        intent.extras?.let {
            category = it.getString("category", "")
        }
        jokerViewModel.getDetailJoker(category)
    }

    private fun setUpObservers() {
        jokerViewModel.resultJoker.observe(this){
            binding.tvValue.text = it.value
            binding.tvUrl.text = it.url
            binding.tvID.text = it.id

            Glide.with(this)
                .load(it.icon_url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .circleCrop()
                .into(binding.imgIcon)
        }
    }
}