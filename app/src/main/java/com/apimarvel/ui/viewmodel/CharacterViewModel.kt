package com.apimarvel.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apimarvel.data.model.Comic
import com.apimarvel.data.model.SuperModel
import com.apimarvel.domain.GetCharacter
import com.apimarvel.domain.GetListComics
import kotlinx.coroutines.launch

class CharacterViewModel:ViewModel() {

    val characterLiveData=MutableLiveData<SuperModel>()
    val comicsLiveData=MutableLiveData<List<Comic>>()
    val getCharacter= GetCharacter()
    val getComics= GetListComics()

    fun getCharacterModel(name:String){
        viewModelScope.launch {
            val character = getCharacter(name)
            characterLiveData.value=character

        }
    }

    fun getListComicsCharacter(name:Int){
        viewModelScope.launch{
            val list=getComics(name)
            comicsLiveData.value=list

        }
    }
}