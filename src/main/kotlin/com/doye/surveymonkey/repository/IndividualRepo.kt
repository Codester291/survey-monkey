package com.doye.surveymonkey.repository

import com.doye.surveymonkey.model.Individual
import org.springframework.data.mongodb.repository.MongoRepository

interface IndividualRepo : MongoRepository<Individual, Long> {
}