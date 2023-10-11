package com.onur.alan.codingmaraton.screens

import android.app.Activity
import android.content.ContentResolver
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.provider.MediaStore
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.onur.alan.codingmaraton.Navigation.Screens
import com.onur.alan.codingmaraton.R
import com.onur.alan.codingmaraton.components.MyBottomAppBar
import com.onur.alan.codingmaraton.components.MyButton
import com.onur.alan.codingmaraton.components.MySendPostButton
import com.onur.alan.codingmaraton.components.SelectImage
import com.onur.alan.codingmaraton.components.SendPostTextField
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.internal.wait
import java.io.ByteArrayOutputStream
import java.io.IOException

@Composable
fun SendPostScreen(viewModel: MarathonViewModel,navController: NavController){

    val context = LocalContext.current
    val activity = LocalView.current.context as ComponentActivity



    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            viewModel.selectedImageUri.value = result.data?.data

        }
    }

    Surface(modifier = Modifier.fillMaxSize(), color = colorResource(id = R.color.my_white),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top


        ) {
            Row(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.1f)
                .padding(start = 10.dp)
                ,
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(painter = painterResource(id = R.drawable.maraton_logo), contentDescription = "", modifier = Modifier.size(48.dp))
                Spacer(modifier = Modifier.width(5.dp))
                Text(text = "MARATON",
                    color = colorResource(id = R.color.my_purple),
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 25.sp)



            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.85f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                Divider(thickness = 2.dp, color = colorResource(id = R.color.my_logo_red), modifier = Modifier.fillMaxWidth())
                Spacer(modifier = Modifier.height(10.dp))
                SelectImage(){
                    val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                    launcher.launch(intent)

                }

                Spacer(modifier = Modifier.height(10.dp))
                SendPostTextField(value = viewModel.sendPostTextField, placeHolder = "açıklama yaz")
                Spacer(modifier = Modifier.height(60.dp))
                MySendPostButton(text = "PAYLAŞ") {
                    CoroutineScope(Dispatchers.Main).launch {
                        viewModel.selectedImageByteArray.value = viewModel.uriToByteArray(context,viewModel.selectedImageUri.value!!)

                        viewModel.createPost()


                    }.invokeOnCompletion {
                        navController.navigate(Screens.PostFeedScreen.route)
                    }

                }

            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically

            ) {
                MyBottomAppBar(navController)

            }

        }

    }

}