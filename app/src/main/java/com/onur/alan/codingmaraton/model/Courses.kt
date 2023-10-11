package com.onur.alan.codingmaraton.model

data class Courses(
    val course_uid:String,
    val course_text:String,
    val course_image:ByteArray,
    val teacherName:String,
    val rate:Float,
    val score:Int
)
