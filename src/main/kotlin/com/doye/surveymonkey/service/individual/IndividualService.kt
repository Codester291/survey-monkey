package com.doye.surveymonkey.service.individual

import com.doye.surveymonkey.config.JwtService
import com.doye.surveymonkey.dto.IndividualDTO
import com.doye.surveymonkey.dto.ResponseDto
import com.doye.surveymonkey.model.Individual
import com.doye.surveymonkey.repository.IndividualRepo
import com.doye.surveymonkey.repository.UserRepo
import com.doye.surveymonkey.service.UserServiceImpl
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service("individualService")
class IndividualService(
    private val individualRepo: IndividualRepo,
    userRepo: UserRepo,
    authenticationManager: AuthenticationManager,
    jwtService: JwtService,
    passwordEncoder: PasswordEncoder
) : UserServiceImpl(userRepo, authenticationManager, jwtService, passwordEncoder) {

    fun register(individualDTO: IndividualDTO): ResponseDto<Any> {
        addUser(individualDTO)

        val individual = Individual()
        individual.firstName = individualDTO.firstName
        individual.lastName = individualDTO.lastName
        individual.purpose = individualDTO.purpose

        individualRepo.save(individual)
        return ResponseDto("00", "Created Individual Successful", individualRepo.save(individual))
    }

    fun getIndividuals(): ResponseDto<Any> {
        return ResponseDto("00", "Successful", individualRepo.findAll())
    }
}