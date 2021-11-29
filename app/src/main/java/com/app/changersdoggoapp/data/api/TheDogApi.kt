package com.app.changersdoggoapp.data.api

import com.app.changersdoggoapp.data.models.DogBreed
import com.app.changersdoggoapp.data.models.DogImage
import retrofit2.http.GET
import retrofit2.http.Query

interface TheDogApi {
    @GET("breeds")
    suspend fun getAllBreeds(): List<DogBreed>

    @GET("images/search")
    suspend fun searchImages(
        @Query("breed_id") breedId: Int,
        @Query("limit") limit: Int
    ): List<DogImage>
}