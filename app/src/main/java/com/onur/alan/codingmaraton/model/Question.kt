package com.onur.alan.codingmaraton.model

data class Question(
    val question_uuid:String,
    val question_image:ByteArray,
    val question_text:String,
    val question_upcount:Int,
    val user_uid:String,
    val userName:String
)
