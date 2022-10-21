package com.apimarvel.ui.view

import android.content.Intent
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.apimarvel.R
import com.apimarvel.data.model.SuperModel

import com.apimarvel.databinding.ViewholdersuperBinding
import com.apimarvel.ui.viewmodel.SuperViewModelMain


import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import com.squareup.picasso.Picasso.Listener
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class viewSuperHolder(private val view:View):RecyclerView.ViewHolder(view) {

    var binding= ViewholdersuperBinding.bind(view)

    fun render(sup:SuperModel,onClickListener:(SuperModel)->Unit){

        binding.textHolder.text=sup.name

        Picasso.get().load(sup.image).into(binding.imageHolder)
        //Glide.with(view).load(sup.image).into(binding.imageHolder)
        binding.imageHolder.setOnClickListener{

            onClickListener(sup)
        }





    }



}