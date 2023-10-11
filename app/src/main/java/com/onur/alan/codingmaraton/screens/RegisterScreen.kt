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
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.onur.alan.codingmaraton.Navigation.Screens
import com.onur.alan.codingmaraton.R
import com.onur.alan.codingmaraton.components.MyButton
import com.onur.alan.codingmaraton.components.MyDoubleTextButton
import com.onur.alan.codingmaraton.components.RegisterTextField
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun RegisterScreen(viewModel: MarathonViewModel,navController: NavController){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = colorResource(id = R.color.my_white)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 20.dp)
            ,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {

            Column(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.9f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                Image(painter = painterResource(id = R.drawable.maraton_logo), contentDescription = "",
                    modifier = Modifier.size(160.dp)
                )
                Text(text = "MARATON", fontSize = 30.sp, fontWeight = FontWeight.SemiBold, color = colorResource(
                    id = R.color.my_purple
                )
                )
                Spacer(modifier = Modifier.height(25.dp))
                RegisterTextField(value = viewModel.registerFirstName, placeHolder ="ad", icon = painterResource(
                    id = R.drawable.first_name
                ))

                Spacer(modifier = Modifier.height(10.dp))

                RegisterTextField(value = viewModel.registerLastName, placeHolder ="soyad", icon = painterResource(
                    id = R.drawable.surename
                ) )

                Spacer(modifier = Modifier.height(10.dp))

                RegisterTextField(value = viewModel.registerUserName, placeHolder ="kullanıcı adı", icon = painterResource(
                    id = R.drawable.username
                ) )
                Spacer(modifier = Modifier.height(10.dp))

                RegisterTextField(value = viewModel.registerEmail, placeHolder ="e-posta", icon = painterResource(
                    id = R.drawable.email
                ) )
                Spacer(modifier = Modifier.height(10.dp))

                RegisterTextField(value = viewModel.registerPassword, placeHolder ="şifre", icon = painterResource(
                    id = R.drawable.password
                ) )
                Spacer(modifier = Modifier.height(20.dp))
                MyButton(text = "KAYIT OL") {
                   CoroutineScope(Dispatchers.Main).launch {
                       viewModel.sendRegister()

                   }.invokeOnCompletion {
                       if (viewModel.registerResponse.value!!.status == 200){
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
                MyDoubleTextButton(firstLink = "Hesabın var mı?", secondLink = "Giriş yap"){
                        navController.navigate(Screens.LoginScreen.route)


                }

            }



        }

    }

}