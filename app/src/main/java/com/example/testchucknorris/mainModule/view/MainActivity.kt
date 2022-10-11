package com.example.testchucknorris.mainModule.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testchucknorris.MainActivityJokerDetail
import com.example.testchucknorris.R
import com.example.testchucknorris.databinding.ActivityMainBinding
import com.example.testchucknorris.mainModule.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel
    private lateinit var categoriesAdapter: CategoriesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        binding.viewModel = mainViewModel
        binding.lifecycleOwner = this
        setContentView(binding.root)

        setUpObservers()
        setRecyclerView()

        mainViewModel.getCategoriesList()
    }

    private fun setRecyclerView() {
        categoriesAdapter = CategoriesAdapter(){
            val intent = Intent(this, MainActivityJokerDetail::class.java)
            intent.putExtra("category", it)
            startActivity(intent)
        }
        binding.recyclerView.apply {
            layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL,
                    false)

            adapter = categoriesAdapter
        }
    }

    private fun setUpObservers() {
        mainViewModel.result.observe(this) { categories ->
            categoriesAdapter.submitList(categories)
        }
    }
}