package com.onur.alan.codingmaraton.network

import com.onur.alan.codingmaraton.model.AskQuestionRequestModel
import com.onur.alan.codingmaraton.model.AskQuestionResponseModel
import com.onur.alan.codingmaraton.model.BuyCourseResponseModel
import com.onur.alan.codingmaraton.model.CourseBuyRequestModel
import com.onur.alan.codingmaraton.model.GetAllCoursesResponseModel
import com.onur.alan.codingmaraton.model.GetAllQuestionsResponseModel
import com.onur.alan.codingmaraton.model.GetOneCourseResponseModel
import com.onur.alan.codingmaraton.model.GetOneQuestionResponseModel
import com.onur.alan.codingmaraton.model.GetSocialPostsResponseModel
import com.onur.alan.codingmaraton.model.LoginRequestModel
import com.onur.alan.codingmaraton.model.OneSocialPost
import com.onur.alan.codingmaraton.model.PostLikeRequestModel
import com.onur.alan.codingmaraton.model.PostLikeResponseModel
import com.onur.alan.codingmaraton.model.PostLoginResponseModel
import com.onur.alan.codingmaraton.model.PostRegisterResponseModel
import com.onur.alan.codingmaraton.model.QuestionAnswerRequestModel
import com.onur.alan.codingmaraton.model.QuestionAnswerResponseModel
import com.onur.alan.codingmaraton.model.QuestionApproveRequestModel
import com.onur.alan.codingmaraton.model.QuestionApproveResponseModel
import com.onur.alan.codingmaraton.model.QuestionUpDownRequestModel
import com.onur.alan.codingmaraton.model.QuestionUpDownResponseModel
import com.onur.alan.codingmaraton.model.RegisterRequestModel
import com.onur.alan.codingmaraton.model.SocialPostCreateRequestModel
import com.onur.alan.codingmaraton.model.SocialPostCreateResponseModel
import com.onur.alan.codingmaraton.model.SocialPostSendCommentRequestModel
import com.onur.alan.codingmaraton.model.UpdateProfileRequestModel
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface APIService {
    @POST("user/register")
    suspend fun postRegister(@Body request: RegisterRequestModel): PostRegisterResponseModel

    @POST("user/login")
    suspend fun postLogin(@Body request:LoginRequestModel ):PostLoginResponseModel

    @GET("/social/posts")
    suspend fun getSocialPosts():GetSocialPostsResponseModel

    @POST("social/post/like")
    suspend fun postData(@Body request:PostLikeRequestModel ):PostLikeResponseModel

    @GET("/social/post/{post_uid}")
    suspend fun getOneSocialPost(@Path("post_uid") post_uid: String):OneSocialPost

    @POST("/social/post/comment")
    suspend fun postData(@Body request:SocialPostSendCommentRequestModel ):PostLoginResponseModel

    @POST("/social/post/create")
    suspend fun postData(@Body request:SocialPostCreateRequestModel ):SocialPostCreateResponseModel

    @GET("/user/profile/{user_uid}/courses")
    suspend fun getSocialPosts(@Path("user_uid") user_uid: String):GetSocialPostsResponseModel

    @POST("/user/profile/update")
    suspend fun postData(@Body request:UpdateProfileRequestModel ):SocialPostCreateResponseModel

    @GET("/courses")
    suspend fun getAllCourses(): GetAllCoursesResponseModel

    @GET("/courses/{course_uid}")
    suspend fun GetOneCourse(@Path("course_uid") course_uid: String):GetOneCourseResponseModel

    @POST("/courses/buy")
    suspend fun postData(@Body request:CourseBuyRequestModel ):BuyCourseResponseModel

    @GET("/social/questions")
    suspend fun getAllQuestions(): GetAllQuestionsResponseModel

    @POST("/social/questions/up")
    suspend fun questionUp(@Body request:QuestionUpDownRequestModel ):QuestionUpDownResponseModel

    @POST("/social/questions/down")
    suspend fun questionDown(@Body request:QuestionUpDownRequestModel ):QuestionUpDownResponseModel

    @POST("/social/questions/answer")
    suspend fun questionDown(@Body request:QuestionAnswerRequestModel ):QuestionAnswerResponseModel

    @GET("/social/questions/{question_uid}")
    suspend fun getOneQuestion(@Path("question_uid") question_uid: String):GetOneQuestionResponseModel

    @POST("/social/questions/approve")
    suspend fun questionApprove(@Body request:QuestionApproveRequestModel ):QuestionApproveResponseModel

    @POST("/social/question/ask")
    suspend fun askQuestion(@Body request:AskQuestionRequestModel ):AskQuestionResponseModel

    @GET("/user/{user_uid}")
    suspend fun getOneUser(@Path("user_uid") user_uid: String):GetOneQuestionResponseModel























}