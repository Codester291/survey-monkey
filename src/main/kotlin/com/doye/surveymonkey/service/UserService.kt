package com.doye.surveymonkey.service

import com.doye.surveymonkey.dto.AuthDto
import com.doye.surveymonkey.dto.ResponseDto
import com.doye.surveymonkey.dto.UserDto
import com.doye.surveymonkey.model.User
import org.springframework.stereotype.Service


interface UserService {
    fun addUser(userDto: UserDto): User
    fun login(authDto: AuthDto): ResponseDto<String>
}