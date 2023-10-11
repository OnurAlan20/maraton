package com.onur.alan.codingmaraton.model

import androidx.core.app.NotificationCompat.MessagingStyle.Message

data class PostRegisterResponseModel(
    val status:Int,
    val message:String
)
data class PostLoginResponseModel(
    val status:Int,
    val message:LoginResponse
)
data class GetSocialPostsResponseModel(
    val status:Int,
    val message:List<SocialPostsResponse>
)
data class PostLikeResponseModel(
    val status:Int,
    val message:String
)
data class SocialPostSendCommentResponseModel(
    val status:Int,
    val message:String
)
data class SocialPostCreateResponseModel(
    val status:Int,
    val message:String
)
data class GetCoursesResponseModel(
    val status:Int,
    val message:List<Courses>
)
data class UpdateProfileResponseModel(
    val status:Int,
    val message:String
)
data class GetAllCoursesResponseModel(
    val status:Int,
    val message:List<Courses>
)
data class GetOneCourseResponseModel(
    val status:Int,
    val message:OneCourse
)
data class BuyCourseResponseModel(
    val status:Int,
    val message:String
)
data class GetAllQuestionsResponseModel(
    val status:Int,
    val message:List<Question>
)
data class QuestionUpDownResponseModel(
    val status:Int,
    val message:String
)
data class QuestionAnswerResponseModel(
    val status:Int,
    val message:String
)
data class GetOneQuestionResponseModel(
    val status:Int,
    val message:OneQuestion
)
data class QuestionApproveResponseModel(
    val status:Int,
    val message:String
)
data class AskQuestionResponseModel(
    val status:Int,
    val message:String
)
data class GetOneUserResponseModel(
    val status:Int,
    val message:OneUser
)



