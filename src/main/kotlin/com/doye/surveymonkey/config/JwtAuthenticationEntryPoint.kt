package com.doye.surveymonkey.config

import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.AuthenticationEntryPoint
import org.springframework.stereotype.Component

@Component
class JwtAuthenticationEntryPoint : AuthenticationEntryPoint{
    override fun commence(
        request: HttpServletRequest?,
        response: HttpServletResponse?,
        authException: AuthenticationException?
    ) {
        val mapper = ObjectMapper()
        val responseObject: MutableMap<String, Any?> = HashMap()

        responseObject["responseCode"] = "03"
        responseObject["responseMessage"] = authException!!.message

        val responseMsg = mapper.writeValueAsString(responseObject)
        response!!.contentType = MediaType.APPLICATION_JSON_VALUE
        response.status = HttpStatus.UNAUTHORIZED.value()
        response.writer.write(responseMsg)
    }

}
