package com.apimarvel.data.network

import com.apimarvel.data.dto.comics.ComicsDTO
import com.apimarvel.data.model.SuperModel
import com.example.marvel.Model.SuperHeroesDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelApiClient {
    @GET("/v1/public/characters")
    suspend fun getApi(
        @Query("ts")ts:String,
        @Query("apikey")apikey:String,
        @Query("hash")hash:String,
        @Query("limit")limit:Int=100,
        @Query("nameStartsWith")nameStartsWith:String


    ): SuperHeroesDTO

    @GET("/v1/public/characters")
    suspend fun getCharacterDTO(
        @Query("ts")ts:String,
        @Query("apikey")apikey:String,
        @Query("hash")hash:String,
        @Query("limit")limit:Int,
        @Query("name")name:String
    ):SuperHeroesDTO

    @GET("/v1/public/comics")
    suspend fun getComicDTO(
        @Query("ts")ts:String,
        @Query("apikey")apikey:String,
        @Query("hash")hash:String,
        @Query("characters")characters:Int,
        @Query("limit")limit:Int
    ):ComicsDTO


}