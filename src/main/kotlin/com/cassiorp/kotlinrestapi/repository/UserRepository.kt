package com.cassiorp.kotlinrestapi.repository

import com.cassiorp.kotlinrestapi.model.UserEntity
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface UserRepository: MongoRepository<UserEntity, String> {

    fun findByEmail(id: String): Optional<UserEntity>

    fun existsByEmail(email: String): Boolean

}