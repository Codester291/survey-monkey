//package com.doye.surveymonkey.controller
//
//import com.doye.surveymonkey.dto.UserDto
//import com.doye.surveymonkey.model.User
//import com.doye.surveymonkey.service.UserService
//import org.springframework.beans.factory.annotation.Qualifier
//import org.springframework.web.bind.annotation.PostMapping
//import org.springframework.web.bind.annotation.RequestBody
//import org.springframework.web.bind.annotation.RequestMapping
//import org.springframework.web.bind.annotation.RestController
//
//@RestController
//@RequestMapping("/user")
//class UserController (
//    private val userService: UserService
//){
//    @PostMapping
//    fun addUser(@RequestBody userDto: UserDto): User? {
//        return userService.addUser(userDto)
//    }
//}