package com.apimarvel.data

import com.apimarvel.data.model.Comic
import com.apimarvel.data.model.SuperModel
import com.apimarvel.data.model.SuperProvider
import com.apimarvel.data.network.SuperService

class SuperRepository {

    suspend fun getSuperModelsNetwork(abc:String):List<SuperModel>{
        var listSuper = mutableListOf<SuperModel>()

        val s= SuperService().getDTO(abc)

            for (i in s.data.results.indices) {

                listSuper.add(
                    i, SuperModel(
                        s.data.results[i].id,
                        s.data.results[i].name,
                        s.data.results[i].description,
                        "${s.data.results[i].thumbnail.path}.${s.data.results[i].thumbnail.extension}",

                    )
                )

        }
        SuperProvider.superModelList.addAll(listSuper)
        return listSuper
    }

    suspend fun getCharacter(name:String):SuperModel{
        val s=SuperService().getCharacterDto(name)
        val character=SuperModel(s.data.results[0].id,s.data.results[0].name,s.data.results[0].description,
            "${s.data.results[0].thumbnail.path}.${s.data.results[0].thumbnail.extension}"
        )
        return character
    }

    suspend fun getComics(name:Int):List<Comic>{
        val list= mutableListOf<Comic>()
        val s=SuperService().getComicsDto(name)
        for (i in s.data.results.indices){

            list.add(
                i,Comic(
                    s.data.results[i].title,
                    "${s.data.results[i].thumbnail.path}.${s.data.results[i].thumbnail.extension}"
                )
            )
        }
        return list
    }




}