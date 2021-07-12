package com.svetikov.examplekotlinpostgresr2dbc5.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("car")
data class Car(
    @Id val id: Int,
    val name: String,
    val series:String,
    val age:Int,
    val id_shop_car:Int
)
