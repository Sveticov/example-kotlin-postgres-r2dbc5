package com.svetikov.examplekotlinpostgresr2dbc5.repository

import com.svetikov.examplekotlinpostgresr2dbc5.model.Usr
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Mono

interface UserRepository:ReactiveCrudRepository<Usr,Long> {
  fun findByUsername(name: String?): Mono<Usr>
}