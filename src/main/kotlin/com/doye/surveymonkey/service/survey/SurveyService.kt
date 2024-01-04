package com.doye.surveymonkey.service.survey

import com.doye.surveymonkey.dto.ResponseDto
import com.doye.surveymonkey.dto.SurveyDTO
import com.doye.surveymonkey.model.SurveyResponse
import com.doye.surveymonkey.repository.SurveyRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SurveyService @Autowired constructor (
    private val surveyRepository: SurveyRepository
) {

    fun createSurvey(surveyDTO: SurveyDTO): ResponseDto<SurveyResponse> {
        return ResponseDto("", "")
    }
}