package com.doye.surveymonkey.controller

import com.doye.surveymonkey.dto.IndividualDTO
import com.doye.surveymonkey.dto.ResponseDto
import com.doye.surveymonkey.service.individual.IndividualService
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/individual")
class IndividualController(
    @Qualifier("individualService") private val individualService: IndividualService
) {

    @ResponseBody
    @PostMapping(consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE])
    fun registerIndividual(@Valid @RequestBody individualDTO: IndividualDTO): ResponseDto<Any> {
        return individualService.register(individualDTO)
    }


    @GetMapping
    fun getIndividuals(): ResponseDto<Any> {
        return individualService.getIndividuals()
    }
}