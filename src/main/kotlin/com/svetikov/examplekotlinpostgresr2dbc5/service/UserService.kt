package com.svetikov.examplekotlinpostgresr2dbc5.service

import com.svetikov.examplekotlinpostgresr2dbc5.repository.UserRepository
import org.springframework.security.core.userdetails.ReactiveUserDetailsService
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono


@Service
class UserService(
    private val repository:UserRepository
) :ReactiveUserDetailsService{
    override fun findByUsername(username: String?): Mono<UserDetails> {
       val data =  repository.findByUsername(username)
        return data.cast(UserDetails::class.java)
    }


}