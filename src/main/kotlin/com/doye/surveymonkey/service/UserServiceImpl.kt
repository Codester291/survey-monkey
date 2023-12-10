package com.doye.surveymonkey.service

import com.doye.surveymonkey.config.JwtService
import com.doye.surveymonkey.dto.AuthDto
import com.doye.surveymonkey.dto.ResponseDto
import com.doye.surveymonkey.dto.UserDto
import com.doye.surveymonkey.enums.Role
import com.doye.surveymonkey.model.User
import com.doye.surveymonkey.repository.UserRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Primary
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service


@Primary
@Service("userService")
class UserServiceImpl @Autowired constructor(
    private val userRepo: UserRepo,
    private val authenticationManager: AuthenticationManager,
    private val jwtService: JwtService,
    private val passwordEncoder: PasswordEncoder
) : UserService {

    override fun addUser(userDto: UserDto): User {
        val user = User()

        user.monkeyName = userDto.username
        user.email = userDto.email
        user.monkeyPassword = passwordEncoder.encode(userDto.password)
        user.role = Role.valueOf(userDto.role)

        return userRepo.save(user)
    }

    override fun login(authDto: AuthDto): ResponseDto<String> {
        authenticationManager.authenticate(
            UsernamePasswordAuthenticationToken(
                authDto.username,
                authDto.password
            )
        )

        val user = userRepo.findByUsername(authDto.username).orElseThrow { RuntimeException("User not found") }
        var token = ""
        if (user != null) {
            token = jwtService.generateToken(user)
        }

        return ResponseDto("00", "Successful", token)
    }

}