package com.svetikov.examplekotlinpostgresr2dbc5.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("shop_car")
data class ShopCar(
    @Id val id: Int,
    var name: String = "",
    var address: String = "",
    var phone: String = "",

)
