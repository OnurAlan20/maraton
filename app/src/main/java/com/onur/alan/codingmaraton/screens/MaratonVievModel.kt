package com.onur.alan.codingmaraton.screens

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.onur.alan.codingmaraton.model.GetSocialPostsResponseModel
import com.onur.alan.codingmaraton.model.LoginRequestModel
import com.onur.alan.codingmaraton.model.PostLoginResponseModel
import com.onur.alan.codingmaraton.model.PostRegisterResponseModel
import com.onur.alan.codingmaraton.model.RegisterRequestModel
import com.onur.alan.codingmaraton.network.APIService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MarathonViewModel:ViewModel(){




    var commentTextField = mutableStateOf("")
    var sendPostTextField = mutableStateOf("")

    var changeUserNameTextField = mutableStateOf("")
    var changeBioTextField = mutableStateOf("")


    fun byteArrayToBitmap(byteArray: ByteArray): Bitmap {
        return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.size)
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



    suspend fun sendRegister() {
        var myUser = RegisterRequestModel(registerEmail.value,registerFirstName.value,registerLastName.value,registerUserName.value,registerPassword.value)
            try {
                val apiResponse = apiService.postRegister(myUser)
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

    suspend fun sendLogin(){
        var myUser = LoginRequestModel(loginEmail.value,loginPassword.value)
            try {
                val apiResponse = apiService.postLogin(myUser)
                loginResponse.value =  apiResponse

            } catch (e: Exception) {
                // Hata yönetimi burada yapılabilir
                e.printStackTrace()
            }

    }

    //post feed screen

    var postLists = mutableStateOf<GetSocialPostsResponseModel?>(null)

    fun getPosts(){
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val apiResponse = apiService.getSocialPosts()
                postLists.value =  apiResponse



            } catch (e: Exception) {
                // Hata yönetimi burada yapılabilir
                e.printStackTrace()
            }
        }
    }











}