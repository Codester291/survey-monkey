package com.doye.surveymonkey.model

import com.doye.surveymonkey.enums.QuestionType
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Field

class Question(
    @Id
    var id: Long,

    var text: String,

    var type: QuestionType,

    @Field("options")
    var option: MutableList<Option>
) {

    constructor() : this(1, "", QuestionType.SINGLE_SELECT, mutableListOf(Option()))
}