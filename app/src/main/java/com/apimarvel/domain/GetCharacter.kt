package com.apimarvel.domain

import com.apimarvel.data.SuperRepository
import com.apimarvel.data.model.SuperModel

class GetCharacter {
  suspend operator fun invoke(n:String): SuperModel = SuperRepository().getCharacter(n)

}