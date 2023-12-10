package com.doye.surveymonkey.dto

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(value = JsonInclude.Include.NON_NULL)
data class ResponseDto<T>(
    val code: String,
    val message: String,
    val data: T? = null
)