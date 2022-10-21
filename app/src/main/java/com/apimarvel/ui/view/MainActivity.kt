package com.apimarvel.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.apimarvel.R

import com.apimarvel.core.AdapterRecyclerCharacters
import com.apimarvel.data.model.SuperModel
import com.apimarvel.databinding.ActivityMainBinding
import com.apimarvel.ui.viewmodel.SuperViewModelMain

open class MainActivity : AppCompatActivity() {






    private lateinit var binding :ActivityMainBinding
    val getViewModel:SuperViewModelMain by viewModels()
    var lista:List<SuperModel> = emptyList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Toolbar
        val toolbar=findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title="Marvel"
        supportActionBar?.setDisplayHomeAsUpEnabled(false)

        //RecyclerView
        getViewModel.superListData.observe(this, Observer { superListData ->
            binding.recyclerView.layoutManager = GridLayoutManager(this, 2)
            binding.recyclerView.adapter = AdapterRecyclerCharacters(superListData) { onItemSelected(it)
            startActivity(Intent(this,CharacterActivity::class.java)
                .putExtra("name",it.name).putExtra("id",it.id))}


        })


        getViewModel.createRecycler()






    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId==R.id.app_bar_frag){
            startActivity(Intent(this,com.apimarvel.ui.view.CharacterActivity::class.java))
        }
        return super.onOptionsItemSelected(item)
    }
    fun onItemSelected(sup:SuperModel){

    }







}




























