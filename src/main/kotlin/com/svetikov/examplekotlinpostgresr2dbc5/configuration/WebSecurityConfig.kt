package com.svetikov.examplekotlinpostgresr2dbc5.configuration

import org.springframework.context.annotation.Bean
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.crypto.password.NoOpPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.server.SecurityWebFilterChain

@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
class WebSecurityConfig {
    @Bean
    fun passwordEncoder():PasswordEncoder =
        NoOpPasswordEncoder.getInstance()

    @Bean
    fun securityWebFilterChain(httpSecurity:ServerHttpSecurity):SecurityWebFilterChain{
        return httpSecurity
            .csrf().disable()
            .formLogin().disable()
            .httpBasic().and()
            .authorizeExchange()
            .pathMatchers("/api","/favicon.ico").permitAll()
            .anyExchange().authenticated()
            .and()
            .logout().logoutUrl("/login")
            .and()

            .build()
    }
}