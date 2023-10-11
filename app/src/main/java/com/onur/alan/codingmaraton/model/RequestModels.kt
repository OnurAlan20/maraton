package com.onur.alan.codingmaraton.model

data class RegisterRequestModel(
    val email:String,
    val firstName:String,
    val lastName:String,
    val userName:String,
    val password:String
)

data class LoginRequestModel(
    val email:String,
    val password:String
)
data class PostLikeRequestModel(
    val user_uid:String,
    val social_post_uid:String
)
data class SocialPostSendCommentRequestModel(
    val user_uid:String,
    val social_post_uid:String,
    val comment_text:String

)
data class SocialPostCreateRequestModel(
    val user_uid:String,
    val post_image:ByteArray,
    val post_text:String

)
data class UpdateProfileRequestModel(
    val userName:String,
    val bio:String,
    val user_image:ByteArray,
    val user_uid: String

)
data class CourseBuyRequestModel(
    val user_uid: String,
    val course_uid:String

)

data class QuestionUpDownRequestModel(
    val user_uid: String,
    val question_uid:String

)

data class QuestionAnswerRequestModel(
    val user_uid: String,
    val question_uid:String,
    val answer_text:String

)
data class QuestionApproveRequestModel(
    val solved_user_uid: String,
    val question_uid:String,
    val answer_uid:String

)
data class AskQuestionRequestModel(
    val user_uid: String,
    val question_image:String,
    val question_text:String

)


