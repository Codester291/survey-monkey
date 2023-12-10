package com.doye.surveymonkey.repository

import com.doye.surveymonkey.model.User
import org.springframework.data.mongodb.repository.MongoRepository
import java.util.Optional

interface UserRepo : MongoRepository<User, Long> {
    fun findByUsername(username: String?) : Optional<User>
}