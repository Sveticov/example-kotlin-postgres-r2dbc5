package com.svetikov.examplekotlinpostgresr2dbc5.repository

import com.svetikov.examplekotlinpostgresr2dbc5.model.ShopCar
import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface ShopCarRepository : CoroutineCrudRepository<ShopCar,Int> {
}