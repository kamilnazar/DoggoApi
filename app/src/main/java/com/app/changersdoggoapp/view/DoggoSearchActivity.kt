package com.app.changersdoggoapp.view

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.app.changersdoggoapp.databinding.ActivityMainBinding
import com.app.changersdoggoapp.util.onItemSelectedListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DoggoSearchActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: DoggoSearchViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = DogImageAdapter()
        viewModel.dogBreeds.observe(this) { dogBreeds ->

            val spinnerData = dogBreeds.map { it.name }.toTypedArray()
            binding.dogBreedSpinner.adapter =
                ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerData)
        }

        viewModel.dogImages.observe(this) { dogImages ->
            adapter.submitList(dogImages)
        }

        binding.dogBreedSpinner.onItemSelectedListener { position ->
            viewModel.dogBreeds.value?.getOrNull(position)?.let {
                viewModel.searchImages(it.id)
            }
        }
        binding.dogImageList.layoutManager = GridLayoutManager(this, 3)
        binding.dogImageList.adapter = adapter
    }
}