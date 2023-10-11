package com.onur.alan.codingmaraton.model

import android.media.Image

data class LoginResponse(
    val user_uid:String,
    val firstName:String,
    val lastName:String,
    val email:String,
    val score:Int,
    val bio:String,
    val userName:String,
    val user_image: ByteArray?

    )
