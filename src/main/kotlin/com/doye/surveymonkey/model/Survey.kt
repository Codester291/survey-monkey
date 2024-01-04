package com.doye.surveymonkey.model

import com.fasterxml.jackson.annotation.JsonFormat
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document
class Survey (
    @Id
    var id: Long,
    var title: String,

    @DBRef
    var user: User,

    @DBRef
    var questions: MutableList<Question>,

    @CreatedDate
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    var createdAt: LocalDateTime
) {
    constructor() : this(1, "", User(), mutableListOf(Question()), LocalDateTime.now())
}