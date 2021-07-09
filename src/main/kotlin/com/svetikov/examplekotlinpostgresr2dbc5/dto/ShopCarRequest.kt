package com.svetikov.examplekotlinpostgresr2dbc5.dto

object ShopCarRequest {
    data class CreateShopCar(val name:String,val address:String,val phone:String)
    data class UpdateShopCar(val id:Int,
    val name:String,
    val address:String,
    val phone:String)
}