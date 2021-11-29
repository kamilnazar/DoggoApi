package com.app.changersdoggoapp.view

import androidx.recyclerview.widget.DiffUtil
import com.app.changersdoggoapp.data.models.DogImage

class DogImageDiffCallback : DiffUtil.ItemCallback<DogImage>() {
    override fun areItemsTheSame(oldItem: DogImage, newItem: DogImage): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: DogImage, newItem: DogImage): Boolean {
        return oldItem == newItem
    }
}