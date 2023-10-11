package com.onur.alan.codingmaraton.screens

import android.graphics.drawable.Drawable
import androidx.appcompat.content.res.AppCompatResources.getDrawable
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.drawable.toBitmap
import androidx.navigation.NavController
import com.onur.alan.codingmaraton.Navigation.Screens
import com.onur.alan.codingmaraton.R
import com.onur.alan.codingmaraton.components.MyBottomAppBar
import com.onur.alan.codingmaraton.components.MyDumyPost
import com.onur.alan.codingmaraton.components.MyPost
import com.onur.alan.codingmaraton.components.MySendPostButton
import kotlinx.coroutines.Dispatchers
import kotlin.random.Random

@Composable
fun PostFeedScreen(viewModel: MarathonViewModel,navController: NavController){
    val context = LocalContext.current
    LaunchedEffect(Dispatchers.IO) {
        viewModel.getPosts()

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
                    .fillMaxHeight(0.80f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                Divider(thickness = 2.dp, color = colorResource(id = R.color.my_logo_red), modifier = Modifier.fillMaxWidth())
                Spacer(modifier = Modifier.height(10.dp))
                var ind =  2;
                LazyColumn {
                    viewModel.postLists.value?.let {
                        items(
                            it.message.asReversed()
                        ){ post->
                            if (post.post_text=="TestPost"){
                                var a = getDrawable(context, R.drawable.kahve_kitap)
                                var b = a?.toBitmap()
                                MyPost(
                                    viewModel = viewModel,
                                    navController = navController,
                                    name = post.userName,
                                    bio = post.post_text,
                                    bitmap = b,
                                    userPP = viewModel.byteArrayToBitmapPP(post.user_image, context = context)
                                )
                            }else{
                                var v = ind
                                println(v)
                                var a:Drawable?;
                                if (v == 1){
                                    a = getDrawable(context,R.drawable.manzara_ornek)
                                }
                                else if (v == 2){
                                    a = getDrawable(context,R.drawable.gri_koc)
                                }
                                else if (v == 3){
                                    a = getDrawable(context, R.drawable.beyaz_kitap)
                                }
                                else{
                                    a = getDrawable(context,R.drawable.mqdefault)
                                }
                                var b = a?.toBitmap()
                                MyPost(
                                    viewModel = viewModel,
                                    navController = navController,
                                    name = post.userName,
                                    bio = post.post_text,
                                    bitmap = b,
                                    userPP = viewModel.byteArrayToBitmapPP(post.user_image, context = context)
                                )
                                ind++;
                            }

                            Spacer(modifier = Modifier.height(6.dp))

                        }
                    }

                }








            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.5f)
                    .padding(end = 15.dp)
                ,
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically

            ) {
                MySendPostButton {
                    navController.navigate(Screens.SendPostScreen.route)

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