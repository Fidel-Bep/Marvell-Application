package com.apimarvel.core

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.apimarvel.R
import com.apimarvel.data.model.SuperModel
import com.apimarvel.ui.view.viewSuperHolder



class AdapterRecyclerCharacters(var list:List<SuperModel>, val onClickListener:(SuperModel)->Unit ): RecyclerView.Adapter<viewSuperHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewSuperHolder {

        val layoutInf=LayoutInflater.from(parent.context)

        return viewSuperHolder(layoutInf.inflate(R.layout.viewholdersuper,parent,false))
    }

    override fun onBindViewHolder(holder: viewSuperHolder, position: Int) {

        val item=list[position]

        holder.render(item,onClickListener)


    }

    override fun getItemCount(): Int = list.size

}