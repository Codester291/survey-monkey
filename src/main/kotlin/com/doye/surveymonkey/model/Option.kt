package com.doye.surveymonkey.model

import org.springframework.data.annotation.Id

class Option (
    @Id
    var id: Long,

    var text: String
) {
    constructor() : this(1, "")
}