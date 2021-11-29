package com.app.changersdoggoapp.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.app.changersdoggoapp.data.models.DogImage
import com.app.changersdoggoapp.databinding.ItemDogImageBinding

class DogImageAdapter : ListAdapter<DogImage, DogImageViewHolder>(DogImageDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogImageViewHolder {
        return DogImageViewHolder(
            ItemDogImageBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: DogImageViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}