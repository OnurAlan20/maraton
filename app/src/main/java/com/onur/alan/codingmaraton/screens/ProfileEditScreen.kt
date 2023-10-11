package com.onur.alan.codingmaraton.screens

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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.onur.alan.codingmaraton.R
import com.onur.alan.codingmaraton.components.LoginTextField
import com.onur.alan.codingmaraton.components.MyBottomAppBar
import com.onur.alan.codingmaraton.components.MyButton
import com.onur.alan.codingmaraton.components.MyCourseBox
import com.onur.alan.codingmaraton.components.RegisterTextField

@Composable
fun ProfileEditScreen(viewModel: MarathonViewModel,navController: NavController){
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
                    .fillMaxHeight(0.90f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                Divider(thickness = 2.dp, color = colorResource(id = R.color.my_logo_red), modifier = Modifier.fillMaxWidth())
                Spacer(modifier = Modifier.height(10.dp))
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Top
                ) {
                    Text(text = "PROFİLİ DÜZENLE",
                        color = colorResource(id = R.color.black),
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 22.sp)
                    Row (modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp),
                        verticalAlignment = Alignment.CenterVertically
                        ){
                        Image(painter = painterResource(id = R.drawable.manzara_ornek),
                            contentDescription ="",
                            modifier = Modifier
                                .clip(shape = CircleShape)
                                .size(100.dp) )
                        Spacer(modifier = Modifier.width(20.dp))
                        Text(text = "profil resmini değiştir",
                            color = colorResource(id = R.color.my_red),
                            fontWeight = FontWeight.Light,
                            fontSize = 19.sp)
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(end = 5.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Top
                    ) {
                        Spacer(modifier = Modifier.height(20.dp))

                        RegisterTextField(value = viewModel.changeUserNameTextField, placeHolder = "kullanıcı adı değiştir", icon = painterResource(
                            id = R.drawable.baseline_edit_24
                        ) )
                        Spacer(modifier = Modifier.height(10.dp))

                        RegisterTextField(value = viewModel.changeBioTextField, placeHolder = "biyografi değiştir", icon = painterResource(
                            id = R.drawable.baseline_edit_24
                        ) )
                        Spacer(modifier = Modifier.height(50.dp))
                        MyButton(text = "GÜNCELLE") {

                        }

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