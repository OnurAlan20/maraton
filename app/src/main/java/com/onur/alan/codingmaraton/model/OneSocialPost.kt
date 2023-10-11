package com.onur.alan.codingmaraton.model

data class OneSocialPost(
    val post_uid:String,
    val post_image:ByteArray,
    val post_text:String,
    val post_like:List<String>,
    val comment_count:Int,
    val comments:List<SocialPostsComment>
)
