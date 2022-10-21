package com.apimarvel.core

import android.content.DialogInterface.OnClickListener
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.apimarvel.R
import com.apimarvel.data.model.Comic
import com.apimarvel.ui.view.viewComicHolder
import com.example.marvel.Model.Comics

class AdapterRecyclerComics(var comics:List<Comic>,val onClickListener: (Comic)->Unit ):RecyclerView.Adapter<viewComicHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewComicHolder {
        val layoutInflater=LayoutInflater.from(parent.context)
        return viewComicHolder(layoutInflater.inflate(R.layout.viewholdercomic,parent,false))
    }

    override fun onBindViewHolder(holder: viewComicHolder, position: Int) {
        val item=comics[position]
        holder.render(item,onClickListener)
    }

    override fun getItemCount(): Int =comics.size


}