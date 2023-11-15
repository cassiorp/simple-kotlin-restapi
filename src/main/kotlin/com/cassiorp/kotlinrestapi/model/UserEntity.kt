package com.cassiorp.kotlinrestapi.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document

@Document("users")
data class UserEntity(
        @Id
        val id: String?,
        var name: String,
        @Indexed(unique = true)
        var email: String
) {}