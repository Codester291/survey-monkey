package com.doye.surveymonkey.repository

import com.doye.surveymonkey.model.Survey
import org.springframework.data.mongodb.repository.MongoRepository

interface SurveyRepository : MongoRepository<Survey, Long>