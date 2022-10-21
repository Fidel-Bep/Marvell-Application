package com.apimarvel.domain

import com.apimarvel.data.SuperRepository
import com.apimarvel.data.model.SuperModel

class GetListSuperHero {

    suspend operator fun invoke(s:String):List<SuperModel> =SuperRepository().getSuperModelsNetwork(s)






}