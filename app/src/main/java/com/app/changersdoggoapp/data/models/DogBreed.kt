package com.app.changersdoggoapp.data.models

import com.squareup.moshi.Json

data class DogBreed(
    @Json(name = "name")
    val name: String,

    @Json(name = "id")
    val id: Int,
//	Not needed for this example
//	@Json(name="image")
//	val image: Image,
//
//	@Json(name="life_span")
//	val lifeSpan: String,
//
//	@Json(name="breed_group")
//	val breedGroup: String,
//
//	@Json(name="origin")
//	val origin: String,
//
//	@Json(name="temperament")
//	val temperament: String,
//
//
//	@Json(name="bred_for")
//	val bredFor: String,
//
//	@Json(name="weight")
//	val weight: Weight,
//

//
//	@Json(name="reference_image_id")
//	val referenceImageId: String,
//
//	@Json(name="height")
//	val height: Height
)

//data class Weight(
//
//	@Json(name="metric")
//	val metric: String,
//
//	@Json(name="imperial")
//	val imperial: String
//)
//
//data class Image(
//
//	@Json(name="width")
//	val width: Int,
//
//	@Json(name="id")
//	val id: String,
//
//	@Json(name="url")
//	val url: String,
//
//	@Json(name="height")
//	val height: Int
//)
//
//data class Height(
//
//	@Json(name="metric")
//	val metric: String,
//
//	@Json(name="imperial")
//	val imperial: String
//)
