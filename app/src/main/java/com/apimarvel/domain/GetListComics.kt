package com.apimarvel.domain

import com.apimarvel.data.SuperRepository
import com.apimarvel.data.model.Comic
import com.apimarvel.data.model.SuperModel

class GetListComics {
    suspend operator fun invoke(n:Int):List<Comic> = SuperRepository().getComics(n)
}