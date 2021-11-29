package com.app.changersdoggoapp.data.repo

import com.app.changersdoggoapp.data.api.TheDogApi
import com.app.changersdoggoapp.data.models.DogBreed
import com.app.changersdoggoapp.data.models.DogImage
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DogApiRepository @Inject constructor(private val theDogApi: TheDogApi) {
    suspend fun getAllDogBreeds(): Result<List<DogBreed>> {
        return runCatching {
            theDogApi.getAllBreeds()
        }
    }

    suspend fun searchImages(breedId: Int, limit: Int = 100): Result<List<DogImage>> {
        return runCatching {
            theDogApi.searchImages(breedId, limit)
        }
    }
}