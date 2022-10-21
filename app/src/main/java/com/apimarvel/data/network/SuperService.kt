package com.apimarvel.data.network

import com.apimarvel.core.Hash
import com.apimarvel.core.RetrofitHelper
import com.apimarvel.data.dto.comics.ComicsDTO
import com.apimarvel.data.model.SuperModel
import com.example.marvel.Model.SuperHeroesDTO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.create

class SuperService {

    suspend fun getDTO(nameStart:String):SuperHeroesDTO{
        return withContext(Dispatchers.IO){
            val response = RetrofitHelper().getRetrofit().create(MarvelApiClient::class.java)
                .getApi(Hash.ts,Hash.API_KEY,Hash.hash,100,nameStart)
            response
        }
    }

    suspend fun getCharacterDto(name:String): SuperHeroesDTO {

        return withContext(Dispatchers.IO){
            val response=RetrofitHelper().getRetrofit().create(MarvelApiClient::class.java)
                .getCharacterDTO(Hash.ts,Hash.API_KEY,Hash.hash,1,name)
            response

        }
    }

    suspend fun getComicsDto(name:Int):ComicsDTO{
        return withContext(Dispatchers.IO){
            val response=RetrofitHelper().getRetrofit().create(MarvelApiClient::class.java)
                .getComicDTO(Hash.ts,Hash.API_KEY,Hash.hash,name,20)
            response

        }
    }

}