package com.apimarvel.ui.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.apimarvel.data.model.Comic
import com.apimarvel.data.model.SuperModel

import com.apimarvel.databinding.ViewholdercomicBinding
import com.squareup.picasso.Picasso

class viewComicHolder(val view:View):RecyclerView.ViewHolder(view) {
    val binding = ViewholdercomicBinding.bind(view)
    fun render(com: Comic, onClickListener: (Comic) -> Unit) {

        binding.textComic.text = com.title

        Picasso.get().load(com.image).into(binding.imageComic)
        //Glide.with(view).load(sup.image).into(binding.imageHolder)
        binding.imageComic.setOnClickListener {

            onClickListener(com)
        }
    }
}