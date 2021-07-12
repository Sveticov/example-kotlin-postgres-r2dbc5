package com.svetikov.examplekotlinpostgresr2dbc5.repository

import com.svetikov.examplekotlinpostgresr2dbc5.model.Car
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface CarRepository:CoroutineCrudRepository<Car,Int> {
    @Query(value="select c.name,c.series,c.age,s.id from car as c inner join shop_car as s on c.id_shop = s.id ")
     suspend fun findAllCar():Collection<Any>
}