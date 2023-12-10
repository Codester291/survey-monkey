package com.doye.surveymonkey.dto

import jakarta.validation.constraints.NotBlank
import java.io.Serializable

class IndividualDTO(
    @NotBlank(message = "firstName cannot be blank")
    val firstName: String,

    @NotBlank(message = "lastName cannot be blank")
    val lastName: String,

    @NotBlank(message = "purpose cannot be blank")
    val purpose: String)

    : Serializable, UserDto()