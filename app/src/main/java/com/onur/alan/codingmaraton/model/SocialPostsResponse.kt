package com.onur.alan.codingmaraton.model

data class SocialPostsResponse(
    val post_uid:String,
    val post_image:ByteArray?,
    val post_text:String,
    val post_like:List<String>,
    val comment_count:Int,
    val userName:String,
    val user_image:ByteArray?
    )
