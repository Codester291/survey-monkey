package com.doye.surveymonkey.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.CorsConfigurationSource
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import org.springframework.web.filter.CorsFilter

@Configuration
@EnableWebSecurity
class SecurityConfig(
    private val authenticationProvider: AuthenticationProvider,
    private val jwtAuthenticationFilter: JwtAuthenticationFilter,
    private val jwtAuthenticationEntryPoint: JwtAuthenticationEntryPoint
) {

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http.cors{
            cors -> cors.configure(http)
        }.csrf {
            csrf -> csrf.disable()
        }.authorizeHttpRequests{
            requests -> run {
                requests.requestMatchers(HttpMethod.POST, "/individual").permitAll()
                requests.requestMatchers("/actuator/**").permitAll()
                requests.requestMatchers("/user/**").permitAll()
                requests.anyRequest().authenticated()
            }
        }.exceptionHandling{
            ex -> ex.authenticationEntryPoint(jwtAuthenticationEntryPoint)
        }.sessionManagement{
            session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        }.authenticationProvider(authenticationProvider)
            .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter::class.java)

        return http.build()
    }

    @Bean
    fun corsConfigurationSource(): CorsConfigurationSource {
        val configuration = CorsConfiguration()
        configuration.allowedOrigins = listOf("*") // Set your allowed origins
        configuration.setAllowedMethods(mutableListOf("GET", "POST", "PUT", "DELETE")) // Set your allowed HTTP methods
        configuration.allowedHeaders = listOf("*") // Set your allowed headers
        val source = UrlBasedCorsConfigurationSource()
        source.registerCorsConfiguration("/**", configuration)
        return source
    }

    @Bean
    fun corsFilter(): CorsFilter {
        return CorsFilter(corsConfigurationSource())
    }
}