package com.app.changersdoggoapp.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.changersdoggoapp.data.models.DogBreed
import com.app.changersdoggoapp.data.models.DogImage
import com.app.changersdoggoapp.data.repo.DogApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class DoggoSearchViewModel @Inject constructor(private val dogApiRepository: DogApiRepository) :
    ViewModel() {
    private val _dogBreeds = MutableLiveData<List<DogBreed>>()
    val dogBreeds: LiveData<List<DogBreed>>
        get() = _dogBreeds

    private val _dogImages = MutableLiveData<List<DogImage>>()
    val dogImages: LiveData<List<DogImage>>
        get() = _dogImages

    init {
        viewModelScope.launch {
            val dogBreedResult = withContext(Dispatchers.IO) { dogApiRepository.getAllDogBreeds() }
            dogBreedResult.onSuccess {
                _dogBreeds.value = it
            }
        }
    }

    fun searchImages(breedId: Int) {
        viewModelScope.launch {
            val breedImagesResult =
                withContext(Dispatchers.IO) { dogApiRepository.searchImages(breedId) }
            breedImagesResult.onSuccess {
                _dogImages.value = it
            }
        }
    }
}