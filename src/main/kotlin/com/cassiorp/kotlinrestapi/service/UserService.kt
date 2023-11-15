package com.cassiorp.kotlinrestapi.service

import com.cassiorp.kotlinrestapi.model.UserEntity
import com.cassiorp.kotlinrestapi.repository.UserRepository
import com.mongodb.DuplicateKeyException
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatus.*
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class UserService(val userRepository: UserRepository) {

    fun createUser(user: UserEntity): UserEntity {
        verifyIfEmailExists(user)
        return userRepository.save(user);
    }

    private fun verifyIfEmailExists(user: UserEntity) {
        if (userRepository.existsByEmail(user.email)) {
            throw ResponseStatusException(UNPROCESSABLE_ENTITY, "Email already exists")
        }
    }

    fun findAll(): List<UserEntity> {
        return userRepository.findAll()
    }

    fun findById(id: String): UserEntity {
        return userRepository.findById(id)
                .orElseThrow { throw ResponseStatusException(NOT_FOUND, "User not found") }
    }

    fun findByEmail(email: String): UserEntity {
        return userRepository.findByEmail(email)
                .orElseThrow { throw ResponseStatusException(NOT_FOUND, "User not found") }
    }

    fun deleteById(id: String) {
        userRepository.deleteById(id);
    }

    fun update(id: String, newUser: UserEntity) {
        var oldUser = this.findById(id)
        if(!oldUser.email.equals(newUser.email)){
            verifyIfEmailExists(newUser)
        }
        oldUser.name = newUser.name
        oldUser.email = newUser.email
        userRepository.save(oldUser)
    }

}
