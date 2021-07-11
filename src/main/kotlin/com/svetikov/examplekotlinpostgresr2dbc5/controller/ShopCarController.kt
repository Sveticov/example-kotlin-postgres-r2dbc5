package com.svetikov.examplekotlinpostgresr2dbc5.controller

import com.svetikov.examplekotlinpostgresr2dbc5.dto.ShopCarRequest
import com.svetikov.examplekotlinpostgresr2dbc5.model.ShopCar
import com.svetikov.examplekotlinpostgresr2dbc5.repository.ShopCarRepository

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/shop")
class ShopCarController(private val repository: ShopCarRepository) {

    @PostMapping
    suspend fun createShopCar(@RequestBody shop: ShopCarRequest.CreateShopCar) {
        val shopNew = ShopCar(0, shop.name, shop.address, shop.phone)
        repository.save(shopNew)
    }

    @GetMapping("/all")
    suspend fun findAllShopCar() =
        repository.findAll()

    @PutMapping
    suspend fun updateShopCar(@RequestBody shop:ShopCarRequest.UpdateShopCar):ResponseEntity<Void>{
        val shopUpdate = repository.findById(shop.id) ?: return ResponseEntity(HttpStatus.NOT_FOUND)

        shopUpdate.name = shop.name
        shopUpdate.address = shop.address
        shopUpdate.phone = shop.phone
        repository.save(shopUpdate)
        return ResponseEntity(HttpStatus.OK)
    }
    @GetMapping("/{id}")
    suspend fun getByIDShop(@PathVariable id:Int) =
        repository.findById(id)

}