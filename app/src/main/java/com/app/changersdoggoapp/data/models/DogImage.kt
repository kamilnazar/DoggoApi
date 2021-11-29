package com.app.changersdoggoapp.data.models

import com.squareup.moshi.Json

data class DogImage(

    @Json(name = "width")
    val width: Int,

    @Json(name = "id")
    val id: String,

    @Json(name = "url")
    val url: String,

    @Json(name = "height")
    val height: Int
)
