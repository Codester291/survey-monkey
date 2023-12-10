package com.doye.surveymonkey.dto

open class UserDto(
    var username: String,
    var email: String,
    var password: String,
    var role: String,
) {
    constructor() : this("", "", "", "")
}
