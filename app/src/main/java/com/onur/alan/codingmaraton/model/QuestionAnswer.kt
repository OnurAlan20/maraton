package com.onur.alan.codingmaraton.model

data class QuestionAnswer(
    val user_uid:String,
    val answer_text:String,
    val answer_uid:String,
    val is_approved:Boolean
)
