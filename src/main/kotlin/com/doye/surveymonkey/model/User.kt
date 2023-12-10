package com.doye.surveymonkey.model

import com.doye.surveymonkey.enums.Role
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.time.LocalDateTime

@Document
data class User (
    @Id
    var id: Long,
    var monkeyName: String,
    var email: String,
    var monkeyPassword: String,
    var role: Role,
    var enabled: Boolean,

    @CreatedDate
    var createdAt: LocalDateTime
) : UserDetails {

    constructor() : this(1, "", "", "", Role.INDIVIDUAL, false, LocalDateTime.now())
    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return mutableListOf(SimpleGrantedAuthority(role.toString()))
    }

    override fun getPassword(): String {
        return monkeyPassword
    }

    override fun getUsername(): String {
        return monkeyName
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return enabled
    }
}