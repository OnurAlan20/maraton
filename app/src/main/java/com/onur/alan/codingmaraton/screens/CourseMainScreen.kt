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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.onur.alan.codingmaraton.R
import com.onur.alan.codingmaraton.components.MyBottomAppBar
import com.onur.alan.codingmaraton.components.MyButton
import com.onur.alan.codingmaraton.components.MyBuyButton
import com.onur.alan.codingmaraton.components.MyCourseBox

@Composable
fun CourseMainScreen(viewModel: MarathonViewModel,navController: NavController){

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
                Spacer(modifier = Modifier.height(30.dp))
                Surface(modifier = Modifier.size(150.dp)) {
                    Image(painter = painterResource(id = R.drawable.manzara_ornek), contentDescription ="" )
                }
                Column(
                    Modifier
                        .fillMaxWidth(0.9f)
                        .padding(top = 10.dp),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Top
                ) {
                    Text(text = "ÜÇGENLERDE AÇILAR",
                        color = colorResource(id = R.color.my_red),
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 25.sp)
                    Spacer(modifier = Modifier.height(10.dp))

                    Text(text = "Şevval Ensarioğlu",
                        color = colorResource(id = R.color.my_red),
                        fontWeight = FontWeight.Light,
                        fontSize = 20.sp)
                    Row (
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 10.dp),
                    ){
                        Text(text = "4.5",
                            color = colorResource(id = R.color.my_red),
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 20.sp)
                        Spacer(modifier = Modifier.width(10.dp))
                        Icon(painter = painterResource(id = R.drawable.baseline_star_24),
                            contentDescription = "",
                            tint = colorResource(
                                id = R.color.my_logo_red
                            ), modifier = Modifier.size(25.dp)
                        )
                        Icon(painter = painterResource(id = R.drawable.baseline_star_24),
                            contentDescription = "",
                            tint = colorResource(
                                id = R.color.my_logo_red
                            ), modifier = Modifier.size(25.dp)
                        )
                        Icon(painter = painterResource(id = R.drawable.baseline_star_24),
                            contentDescription = "",
                            tint = colorResource(
                                id = R.color.my_logo_red
                            ), modifier = Modifier.size(25.dp)
                        )
                        Icon(painter = painterResource(id = R.drawable.baseline_star_24),
                            contentDescription = "",
                            tint = colorResource(
                                id = R.color.my_logo_red
                            ), modifier = Modifier.size(25.dp)
                        )
                        Icon(painter = painterResource(id = R.drawable.baseline_star_border_24),
                            contentDescription = "",
                            tint = colorResource(
                                id = R.color.my_logo_red
                            ), modifier = Modifier.size(25.dp)
                        )
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
                Surface(modifier = Modifier
                    .fillMaxWidth(0.9F)
                    .height(150.dp),
                    color = colorResource(id = R.color.my_platinum),
                    shape = RoundedCornerShape(15.dp)
                    ) {
                    Column(modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 10.dp, start = 10.dp)) {
                        Text(text = "KAZANIMLAR",
                            color = colorResource(id = R.color.my_red),
                            fontWeight = FontWeight.Light,
                            fontSize = 20.sp)
                        Spacer(modifier = Modifier.height(5.dp))
                        Text(text = "vjkakjkedjfn fjkvdjksnjhvf sjkdfvcfkjshnfj bcjfkhsjfv",
                            color = colorResource(id = R.color.black),
                            fontWeight = FontWeight.Light,
                            fontSize = 18.sp)


                    }

                }
                Row(
                    modifier = Modifier.fillMaxSize().padding(start = 40.dp),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.Bottom
                ) {
                    Text(text = "750MP",
                        color = colorResource(id = R.color.my_red),
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 22.sp, modifier = Modifier.padding(bottom = 20.dp))
                    Spacer(modifier = Modifier.padding(40.dp))
                    MyBuyButton(text = "SATIN AL") {

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

