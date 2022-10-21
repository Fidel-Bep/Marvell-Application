package com.apimarvel.ui.viewmodel

import androidx.lifecycle.*
import com.apimarvel.R
import com.apimarvel.data.model.SuperModel
import com.apimarvel.domain.GetListSuperHero
import com.apimarvel.ui.view.MainActivity
import kotlinx.coroutines.*

class SuperViewModelMain:ViewModel() {

    var superListData = MutableLiveData<List<SuperModel>>()
    var superString=MutableLiveData<String>()


    val getList=GetListSuperHero()


    fun createRecycler() {
        viewModelScope.launch {
            val abc="abcdefghijklmnopqrstuvwxyz"

                val listaSuper=getList(abc[0].toString())
                superListData.value=listaSuper
        }
    }







}
