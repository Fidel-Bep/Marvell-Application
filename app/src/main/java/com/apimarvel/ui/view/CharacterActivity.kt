package com.apimarvel.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.HorizontalScrollView
import androidx.activity.viewModels
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.liveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.apimarvel.R
import com.apimarvel.core.AdapterRecyclerComics
import com.apimarvel.data.model.Comic
import com.apimarvel.databinding.ActivityCharacterBinding
import com.apimarvel.ui.viewmodel.CharacterViewModel
import com.squareup.picasso.Picasso
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class CharacterActivity : AppCompatActivity() {

    lateinit var binding:ActivityCharacterBinding
    val getCharacterViewModel:CharacterViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityCharacterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name= intent.getStringExtra("name")
        val ide=intent.getIntExtra("id",0)

        //Toolbar
        val toolbar=findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title=name
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        getCharacterViewModel.characterLiveData.observe(this, Observer {
            Picasso.get().load(it.image).into(binding.imageCharacter)
            binding.textViewName.text = it.name
            binding.textViewDescription.text = it.description

            })
            getCharacterViewModel.getCharacterModel(name!!)



        getCharacterViewModel.comicsLiveData.observe(this,Observer{ comicsLiveData ->
            binding.recyclerComics.layoutManager=LinearLayoutManager(this,RecyclerView.HORIZONTAL,false)
            binding.recyclerComics.adapter=AdapterRecyclerComics(comicsLiveData){onClickItem(it)}
        })


            getCharacterViewModel.getListComicsCharacter(ide)






    }

    fun onClickItem(c: Comic){}
}