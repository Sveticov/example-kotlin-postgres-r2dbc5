package com.svetikov.examplekotlinpostgresr2dbc5.dto

object RequestCar {
    data class CreateCar(val name: String,val series:String,val age :Int)
    data class UpdateCar(val id:Int,val name:String,val series:String,val age:Int)
}