package com.onur.alan.codingmaraton.screens

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.Drawable
import android.net.Uri
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toBitmap
import androidx.lifecycle.ViewModel
import com.onur.alan.codingmaraton.R
import com.onur.alan.codingmaraton.model.AskQuestionRequestModel
import com.onur.alan.codingmaraton.model.AskQuestionResponseModel
import com.onur.alan.codingmaraton.model.GetAllCoursesResponseModel
import com.onur.alan.codingmaraton.model.GetOneQuestionResponseModel
import com.onur.alan.codingmaraton.model.GetSocialPostsResponseModel
import com.onur.alan.codingmaraton.model.LastPostComment
import com.onur.alan.codingmaraton.model.LoginRequestModel
import com.onur.alan.codingmaraton.model.PostLoginResponseModel
import com.onur.alan.codingmaraton.model.PostRegisterResponseModel
import com.onur.alan.codingmaraton.model.RegisterRequestModel
import com.onur.alan.codingmaraton.model.SocialPostCreateRequestModel
import com.onur.alan.codingmaraton.model.SocialPostCreateResponseModel
import com.onur.alan.codingmaraton.model.SocialPostSendCommentRequestModel
import com.onur.alan.codingmaraton.network.APIService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.BufferedInputStream
import java.io.ByteArrayOutputStream
import java.io.IOException

class MarathonViewModel:ViewModel(){




    var commentTextField = mutableStateOf("")

    var changeUserNameTextField = mutableStateOf("")
    var changeBioTextField = mutableStateOf("")


    fun byteArrayToBitmap(byteArray: ByteArray?,context: Context): Bitmap? {
        if (byteArray == null){
            val drawable: Drawable? = ContextCompat.getDrawable(context, R.drawable.beyaz_kitap)

            return drawable?.toBitmap()
        }else{
            return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.size)

        }
    }
    fun byteArrayToBitmapPP(byteArray: ByteArray?,context: Context): Bitmap? {
        if (byteArray == null){
            val drawable: Drawable? = ContextCompat.getDrawable(context, R.drawable.account)

            return drawable?.toBitmap()
        }else{
            return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.size)

        }
    }

    //Retrofit
    lateinit var retrofit:Retrofit
    lateinit var apiService:APIService


    fun initRetrofit(){
        GlobalScope.launch {
            val client = OkHttpClient.Builder().build()
            retrofit = Retrofit.Builder()
                .client(client)
                .baseUrl("http://159.138.21.194:8081/") // API URL'sini buraya ekleyin
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            apiService = retrofit.create(APIService::class.java)
        }
    }

    //RegisterScreen
    var registerFirstName = mutableStateOf("")
    var registerLastName = mutableStateOf("")
    var registerUserName = mutableStateOf("")
    var registerEmail = mutableStateOf("")
    var registerPassword = mutableStateOf("")

    var registerResponse= mutableStateOf<PostRegisterResponseModel?>(null)



    @SuppressLint("SuspiciousIndentation")
    suspend fun sendRegister() {
        var myUser1 = RegisterRequestModel(registerEmail.value,registerFirstName.value,registerLastName.value,registerUserName.value,registerPassword.value)
            try {
                val apiResponse = apiService.postRegister(myUser1)
                registerResponse.value =  apiResponse
            } catch (e: Exception) {
                // Hata yönetimi burada yapılabilir
                e.printStackTrace()
            }

    }
    //loginScreen
    var loginEmail = mutableStateOf("")
    var loginPassword = mutableStateOf("")
    var loginResponse= mutableStateOf<PostLoginResponseModel?>(null)

    @SuppressLint("SuspiciousIndentation")
    suspend fun sendLogin(){
        var myUser = LoginRequestModel(loginEmail.value,loginPassword.value)
            try {
                val apiResponse = apiService.postLogin(myUser)
                loginResponse.value =  apiResponse
                println(loginResponse.value?.message?.lastName)

            } catch (e: Exception) {
                // Hata yönetimi burada yapılabilir
                e.printStackTrace()
            }

    }

    //post feed screen

    var postLists = mutableStateOf<GetSocialPostsResponseModel?>(null)

    suspend fun getPosts(){

            try {
                val apiResponse = apiService.getSocialPosts()
                postLists.value =  apiResponse
                println(postLists.value)


            } catch (e: Exception) {
                // Hata yönetimi burada yapılabilir
                e.printStackTrace()
            }

    }

    //create post screen

    var createPostResponse = mutableStateOf<SocialPostCreateResponseModel?>(null)



    var selectedImageUri = mutableStateOf<Uri?>(null)

    var selectedImageByteArray = mutableStateOf<ByteArray?>(null)

    var sendPostTextField = mutableStateOf("")

    suspend fun createPost(){
        try {
            var myCreatePost = SocialPostCreateRequestModel(loginResponse.value!!.message.user_uid,null,sendPostTextField.value)

            val apiResponse = apiService.postCreateSocialPost(myCreatePost!!)
            createPostResponse.value =  apiResponse



        } catch (e: Exception) {
            // Hata yönetimi burada yapılabilir
            e.printStackTrace()
        }

    }
    suspend fun uriToByteArray(context: Context, uri: Uri): ByteArray? {
        return withContext(Dispatchers.IO) {
            var byteArray: ByteArray? = null
            try {
                val inputStream = BufferedInputStream(context.contentResolver.openInputStream(uri))
                val outputStream = ByteArrayOutputStream()

                val buffer = ByteArray(1024)
                var bytesRead: Int
                while (inputStream.read(buffer).also { bytesRead = it } != -1) {
                    outputStream.write(buffer, 0, bytesRead)
                }

                byteArray = outputStream.toByteArray()

                inputStream.close()
                outputStream.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
            byteArray
        }
    }

    //get questions screen
    var questionLists = mutableStateOf<GetAllCoursesResponseModel?>(null)

    suspend fun getCourses(){

        try {
            val apiResponse = apiService.getAllCourses()
            questionLists.value =  apiResponse


        } catch (e: Exception) {
            // Hata yönetimi burada yapılabilir
            e.printStackTrace()
        }

    }
    // One question request
    var oneQuestionValue = mutableStateOf<GetOneQuestionResponseModel?>(null)

    suspend fun getCourses(uid:String){

        try {
            val apiResponse = apiService.getOneQuestion(uid)
            oneQuestionValue.value =  apiResponse


        } catch (e: Exception) {
            // Hata yönetimi burada yapılabilir
            e.printStackTrace()
        }

    }
    //send question


    var askQuestionResponse= mutableStateOf<AskQuestionResponseModel?>(null)
    var askQuestionTextField = mutableStateOf("")

    @SuppressLint("SuspiciousIndentation")
    suspend fun sendQuestion(){
        var a = AskQuestionRequestModel(loginResponse.value!!.message.user_uid, null,question_text =askQuestionTextField.value )
        try {
            val apiResponse = apiService.askQuestion(a)
            askQuestionResponse.value =  apiResponse


        } catch (e: Exception) {
            // Hata yönetimi burada yapılabilir
            e.printStackTrace()
        }

    }

    var myBitmap = mutableStateOf<Bitmap?>(null)

    var postCommentList = mutableStateListOf<LastPostComment>(LastPostComment(name = "Onur Alan", message = "Bu baya iyi post yanlız!"),LastPostComment(name = "Onur Alan", message = "Bu baya iyi post yanlız!"),LastPostComment(name = "Onur Alan", message = "Bu baya iyi post yanlız!"))

    var questionAnswerList = mutableStateListOf<LastPostComment>(
        LastPostComment(name = "Onur Alan", message = "6+4 = 10 "),
        LastPostComment(name = "Onur Alan", message = "H20 hidrojen ve oksijenden oluşur "),


        )
    var answerTextField = mutableStateOf("")













}