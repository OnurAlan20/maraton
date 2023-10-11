package com.onur.alan.codingmaraton.model

data class OneQuestion(
    val question_uid:String,
    val question_image:ByteArray,
    val question_text:String,
    val question_upcount:Int,
    val question_answer_count:Int,
    val user_uid:String,
    val userName:String,
    val approved_answer:String,
    val question_answer_list:List<QuestionAnswer>

)
