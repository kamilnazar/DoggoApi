package com.app.changersdoggoapp.view

import androidx.recyclerview.widget.RecyclerView
import com.app.changersdoggoapp.data.models.DogImage
import com.app.changersdoggoapp.databinding.ItemDogImageBinding
import com.squareup.picasso.Picasso

class DogImageViewHolder(private val itemDogImageBinding: ItemDogImageBinding) :
    RecyclerView.ViewHolder(itemDogImageBinding.root) {
    fun bind(dogImage: DogImage) {
        Picasso.get()
            .load(dogImage.url)
            .resize(300, 300)
            .centerCrop()
            .into(itemDogImageBinding.imageView)
    }
}
