package com.svetikov.examplekotlinpostgresr2dbc5.repository

import com.svetikov.examplekotlinpostgresr2dbc5.model.Car
import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface CarRepository:CoroutineCrudRepository<Car,Int> {
}