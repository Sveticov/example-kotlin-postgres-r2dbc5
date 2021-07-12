package com.svetikov.examplekotlinpostgresr2dbc5.controller

import com.svetikov.examplekotlinpostgresr2dbc5.dto.RequestCar
import com.svetikov.examplekotlinpostgresr2dbc5.model.Car
import com.svetikov.examplekotlinpostgresr2dbc5.repository.CarRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/api/car")
class CarController(private val repository: CarRepository) {

    @ExceptionHandler(NoSuchElementException::class)
    fun noCar(e: NoSuchElementException): ResponseEntity<String> = ResponseEntity.ok(e.toString())

    @PostMapping()
    suspend fun createCar(@RequestBody car: RequestCar.CreateCar) {

        val createNewCar = Car(0, car.name, car.series, car.age,0)
        repository.save(createNewCar)
    }

    @GetMapping("/all")
    suspend fun findAllCar() =
        repository.findAll()

    @GetMapping("/{id}")
    suspend fun findCarByID(@PathVariable id: Int) =
        repository.findById(id) ?: throw NoSuchElementException("This car with id: $id not exists")
}