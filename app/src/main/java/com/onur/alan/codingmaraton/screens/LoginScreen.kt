package com.onur.alan.codingmaraton.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.onur.alan.codingmaraton.Navigation.Screens
import com.onur.alan.codingmaraton.R
import com.onur.alan.codingmaraton.components.LoginTextField
import com.onur.alan.codingmaraton.components.MyButton
import com.onur.alan.codingmaraton.components.MyDoubleTextButton
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(viewModel: MarathonViewModel,navController: NavController){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = colorResource(id = R.color.my_white)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 80.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {

            Column(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.8f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
                ) {
                Image(painter =painterResource(id = R.drawable.maraton_logo), contentDescription = "",
                    modifier = Modifier.size(160.dp)
                )
                Text(text = "MARATON", fontSize = 30.sp, fontWeight = FontWeight.SemiBold, color = colorResource(
                    id = R.color.my_purple
                ))
                Spacer(modifier = Modifier.height(70.dp))
                LoginTextField(value = viewModel.loginEmail, placeHolder ="e-posta", icon =Icons.Outlined.Email )

                Spacer(modifier = Modifier.height(20.dp))

                LoginTextField(value = viewModel.loginPassword, placeHolder ="şifre", icon =Icons.Outlined.Lock )
                Spacer(modifier = Modifier.height(35.dp))
                MyButton(text = "GİRİŞ YAP") {

                    CoroutineScope(Dispatchers.Main).launch {
                        viewModel.sendLogin()

                    }.invokeOnCompletion {
                        if (viewModel.loginResponse.value?.status == 200){
                            navController.navigate(Screens.LoginScreen.route)
                        }
                    }



                }
            }
            Column(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(bottom = 30.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom
            ) {
                MyDoubleTextButton(firstLink = "Hesabın yok mu?", secondLink = "Kayıt ol"){
                    navController.navigate(Screens.RegisterScreen.route)

                }

            }



        }

    }

}


