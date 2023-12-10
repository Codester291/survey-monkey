package com.doye.surveymonkey.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document

@Document
class Individual (
    @Id
    var id: Long,
    var firstName: String,
    var lastName: String,
    var purpose: String,

    @DBRef
    var user: User
) {
    constructor() : this(1, "", "", "", User())
}