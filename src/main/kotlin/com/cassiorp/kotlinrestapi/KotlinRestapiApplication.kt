package com.cassiorp.kotlinrestapi

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@OpenAPIDefinition
class KotlinRestapiApplication

fun main(args: Array<String>) {
	runApplication<KotlinRestapiApplication>(*args)
}
