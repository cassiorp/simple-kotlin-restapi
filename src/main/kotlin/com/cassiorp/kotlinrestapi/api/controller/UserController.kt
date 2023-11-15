package com.cassiorp.kotlinrestapi.api.controller

import com.cassiorp.kotlinrestapi.model.UserEntity
import com.cassiorp.kotlinrestapi.service.UserService
import org.springframework.http.HttpStatus.CREATED
import org.springframework.http.HttpStatus.OK
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/users")
class UserController(private val userService: UserService) {

    @PostMapping
    fun createUser(@RequestBody userEntity: UserEntity): ResponseEntity<UserEntity> {
        return ResponseEntity(userService.createUser(userEntity), CREATED);
    }

    @GetMapping
    fun getAllUsers(): ResponseEntity<List<UserEntity>>{
        return ResponseEntity(userService.findAll(), OK)
    }

    @GetMapping("/{id}")
    fun getUserByID(@PathVariable id: String): ResponseEntity<UserEntity>{
        return ResponseEntity(userService.findById(id), OK)
    }

    @GetMapping("/email/{email}")
    fun getUserByEmail(@PathVariable email: String): ResponseEntity<UserEntity>{
        return ResponseEntity(userService.findByEmail(email), OK)
    }

    @DeleteMapping("/{id}")
    fun deleteUserByID(@PathVariable id: String): ResponseEntity<UserEntity>{
        userService.deleteById(id)
        return ResponseEntity(OK)
    }

    @PutMapping("/{id}")
    fun updateUser(@PathVariable id: String, @RequestBody userEntity: UserEntity): ResponseEntity<UserEntity>{
        userService.update(id, userEntity)
        return ResponseEntity(OK);
    }

}