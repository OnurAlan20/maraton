package com.onur.alan.codingmaraton.components

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.ImageLoader
import coil.decode.ImageSource
import coil.request.ImageRequest
import com.onur.alan.codingmaraton.Navigation.Screens
import com.onur.alan.codingmaraton.R
import com.onur.alan.codingmaraton.model.LastPostComment
import com.onur.alan.codingmaraton.screens.MarathonViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.http.Multipart

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginTextField(value: MutableState<String>, placeHolder:String, icon: ImageVector){
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(0.89f),
        textStyle = TextStyle(fontSize = 22.sp, color = colorResource(id = R.color.my_red),fontWeight = FontWeight.Light),
        value = value.value,
        onValueChange = {
            // Inside this lambda, 'it' refers to the new value of the text field
            value.value = it
        },
        placeholder = {
            // You can use the 'placeHolder' parameter directly here
            Text(text = placeHolder, fontSize = 22.sp, color = colorResource(id = R.color.my_red), fontWeight = FontWeight.Light)
        },
        shape = RoundedCornerShape(20.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = colorResource(id = R.color.black),
            cursorColor = colorResource(id = R.color.my_platinum),
            focusedBorderColor = colorResource(id = R.color.my_platinum),
            unfocusedBorderColor = colorResource(id = R.color.my_platinum),
            containerColor = colorResource(id = R.color.my_platinum)

        ),
        leadingIcon = {
            Icon(
                imageVector = icon,
                contentDescription = "Leading Icon",
                tint = colorResource(id = R.color.my_logo_red)
            )
        }

    )





}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginPasswordTextField(value: MutableState<String>, placeHolder:String, icon: ImageVector){

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(0.89f),
        textStyle = TextStyle(fontSize = 22.sp, color = colorResource(id = R.color.my_red),fontWeight = FontWeight.Light),
        value = value.value,
        visualTransformation =  PasswordVisualTransformation(),
        onValueChange = {
            // Inside this lambda, 'it' refers to the new value of the text field
            value.value = it
        },
        placeholder = {
            // You can use the 'placeHolder' parameter directly here
            Text(text = placeHolder, fontSize = 22.sp, color = colorResource(id = R.color.my_red), fontWeight = FontWeight.Light)
        },
        shape = RoundedCornerShape(20.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = colorResource(id = R.color.black),
            cursorColor = colorResource(id = R.color.my_platinum),
            focusedBorderColor = colorResource(id = R.color.my_platinum),
            unfocusedBorderColor = colorResource(id = R.color.my_platinum),
            containerColor = colorResource(id = R.color.my_platinum)

        ),
        leadingIcon = {
            Icon(
                imageVector = icon,
                contentDescription = "Leading Icon",
                tint = colorResource(id = R.color.my_logo_red)
            )
        }

    )





}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterTextField(value: MutableState<String>, placeHolder:String, icon: Painter){

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(0.89f),
        textStyle = TextStyle(fontSize = 22.sp, color = colorResource(id = R.color.my_red),fontWeight = FontWeight.Light),
        value = value.value,
        onValueChange = {
            // Inside this lambda, 'it' refers to the new value of the text field
            value.value = it
        },
        placeholder = {
            // You can use the 'placeHolder' parameter directly here
            Text(text = placeHolder, fontSize = 22.sp, color = colorResource(id = R.color.my_red), fontWeight = FontWeight.Light)
        },
        shape = RoundedCornerShape(20.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = colorResource(id = R.color.black),
            cursorColor = colorResource(id = R.color.my_platinum),
            focusedBorderColor = colorResource(id = R.color.my_platinum),
            unfocusedBorderColor = colorResource(id = R.color.my_platinum),
            containerColor = colorResource(id = R.color.my_platinum)

        ),
        leadingIcon = {
            Icon(
                painter = icon,
                contentDescription = "Leading Icon",
                tint = colorResource(id = R.color.my_logo_red)
            )
        }

    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterPasswordTextField(value: MutableState<String>, placeHolder:String, icon: Painter){

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(0.89f),
        textStyle = TextStyle(fontSize = 22.sp, color = colorResource(id = R.color.my_red),fontWeight = FontWeight.Light),
        value = value.value,
        visualTransformation = PasswordVisualTransformation(),
        onValueChange = {
            // Inside this lambda, 'it' refers to the new value of the text field
            value.value = it
        },
        placeholder = {
            // You can use the 'placeHolder' parameter directly here
            Text(text = placeHolder, fontSize = 22.sp, color = colorResource(id = R.color.my_red), fontWeight = FontWeight.Light)
        },
        shape = RoundedCornerShape(20.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = colorResource(id = R.color.black),
            cursorColor = colorResource(id = R.color.my_platinum),
            focusedBorderColor = colorResource(id = R.color.my_platinum),
            unfocusedBorderColor = colorResource(id = R.color.my_platinum),
            containerColor = colorResource(id = R.color.my_platinum)

        ),
        leadingIcon = {
            Icon(
                painter = icon,
                contentDescription = "Leading Icon",
                tint = colorResource(id = R.color.my_logo_red)
            )
        }

    )





}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CommentTextField(value: MutableState<String>, placeHolder:String, icon: Painter,viewModel: MarathonViewModel){

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(0.89f),
        textStyle = TextStyle(fontSize = 22.sp, color = colorResource(id = R.color.my_red),fontWeight = FontWeight.Light),
        value = value.value,
        onValueChange = {
            // Inside this lambda, 'it' refers to the new value of the text field
            value.value = it
        },
        placeholder = {
            // You can use the 'placeHolder' parameter directly here
            Text(text = placeHolder, fontSize = 22.sp, color = colorResource(id = R.color.my_red), fontWeight = FontWeight.Light)
        },
        shape = RoundedCornerShape(20.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = colorResource(id = R.color.black),
            cursorColor = colorResource(id = R.color.my_platinum),
            focusedBorderColor = colorResource(id = R.color.my_platinum),
            unfocusedBorderColor = colorResource(id = R.color.my_platinum),
            containerColor = colorResource(id = R.color.my_platinum)

        ),
        trailingIcon = {
            Icon(
                painter = icon,
                contentDescription = "Leading Icon",
                tint = colorResource(id = R.color.my_logo_red),
                modifier = Modifier.clickable {
                    viewModel.postCommentList.add(
                    LastPostComment(viewModel.loginResponse.value!!.message.userName,viewModel.commentTextField.value)
                )
                }

            )
        }

    )





}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnswerTextField(value: MutableState<String>, placeHolder:String, icon: Painter,viewModel: MarathonViewModel){

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(0.89f),
        textStyle = TextStyle(fontSize = 22.sp, color = colorResource(id = R.color.my_red),fontWeight = FontWeight.Light),
        value = value.value,
        onValueChange = {
            // Inside this lambda, 'it' refers to the new value of the text field
            value.value = it
        },
        placeholder = {
            // You can use the 'placeHolder' parameter directly here
            Text(text = placeHolder, fontSize = 22.sp, color = colorResource(id = R.color.my_red), fontWeight = FontWeight.Light)
        },
        shape = RoundedCornerShape(20.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = colorResource(id = R.color.black),
            cursorColor = colorResource(id = R.color.my_platinum),
            focusedBorderColor = colorResource(id = R.color.my_platinum),
            unfocusedBorderColor = colorResource(id = R.color.my_platinum),
            containerColor = colorResource(id = R.color.my_platinum)

        ),
        trailingIcon = {
            Icon(
                painter = icon,
                contentDescription = "Leading Icon",
                tint = colorResource(id = R.color.my_logo_red),
                modifier = Modifier.clickable {
                    viewModel.questionAnswerList.add(
                        LastPostComment(viewModel.loginResponse.value!!.message.userName,viewModel.answerTextField.value)
                    )
                }

            )
        }

    )





}

@Composable
fun MyButton(text:String,onClick: () -> Unit){
    Button(onClick = { onClick() },
        modifier = Modifier
            .fillMaxWidth(0.60f)
            .height(60.dp)
        ,
        colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.my_login_orange)),
        shape = RoundedCornerShape(15.dp)
    ) {
        Text(text = text, fontSize = 25.sp, color = colorResource(id = R.color.my_white), fontWeight = FontWeight.SemiBold )
    }

}

@Composable
fun MyDoubleTextButton(firstLink:String,secondLink:String,onClick: () -> Unit){
    Row(modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
        ) {
        Text(text =firstLink , fontSize = 19.sp, color = colorResource(id = R.color.my_red), fontWeight = FontWeight.Light)
        TextButton(onClick = {
            onClick()
        }) {
            Text(text =secondLink , fontSize = 19.sp, color = colorResource(id = R.color.my_logo_red), fontWeight = FontWeight.Light)
        }

    }
}

@Composable
fun MyBottomAppBar(navController: NavController){
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ){
        IconButton(onClick = {
           navController.navigate(Screens.PostFeedScreen.route)
        }) {
            Icon(painter = painterResource(id = R.drawable.outline_home), contentDescription ="", tint = colorResource(
                id = R.color.my_logo_red
            ), modifier = Modifier.size(35.dp) )
        }
        IconButton(onClick = {
            navController.navigate(Screens.ForumMainScreen.route)

        }) {
            Icon(painter = painterResource(id = R.drawable.outline_question), contentDescription ="", tint = colorResource(
                id = R.color.my_logo_red
            ), modifier = Modifier.size(35.dp) )

        }
        IconButton(onClick = {
            navController.navigate(Screens.CoursesScreen.route)

        }) {
            Icon(painter = painterResource(id = R.drawable.outline_course), contentDescription ="", tint = colorResource(
                id = R.color.my_logo_red
            ), modifier = Modifier.size(35.dp) )

        }
        IconButton(onClick = {
            navController.navigate(Screens.ProfileScreen.route)

        }) {
            Icon(painter = painterResource(id = R.drawable.outline_person), contentDescription ="", tint = colorResource(
                id = R.color.my_logo_red
            ), modifier = Modifier.size(35.dp) )

        }


    }

}

@Composable
fun MyPost(
    viewModel: MarathonViewModel,
    navController: NavController,
    name:String,
    bio:String,
    bitmap: Bitmap?,
    userPP: Bitmap?
){
    Surface(modifier = Modifier
        .fillMaxWidth(0.9f)
        .fillMaxHeight(0.8f),
        shape = RoundedCornerShape(15.dp),
        color = colorResource(id = R.color.my_platinum)
        ) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()) {
            Row(modifier = Modifier
                .fillMaxHeight(0.10f)
                .fillMaxWidth()
                .padding(start = 10.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
                ) {

                Image(bitmap = userPP!!.asImageBitmap(), contentDescription ="", modifier = Modifier.size(30.dp).clip(shape = CircleShape) )
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = name,
                    color = colorResource(id = R.color.my_red),
                    fontSize = 22.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
            Column(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.8f)) {
                Image(bitmap = bitmap!!.asImageBitmap(),
                    contentDescription ="",
                    modifier = Modifier.fillMaxSize() )
            }
            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(start = 12.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = bio,
                    color = colorResource(id = R.color.black),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Light,

                )
            }
            Row(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(end = 10.dp),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
                ) {
                IconButton(onClick = { /*TODO*/ },
                    ) {
                    Icon(painter = painterResource(id = R.drawable.outlined_favorite),
                        contentDescription = "",
                        tint = colorResource(
                            id = R.color.my_logo_red
                        ), modifier = Modifier.size(25.dp)
                        )

                }

                IconButton(onClick = {
                     navController.navigate(Screens.PostCommentScreen.route)
                },
                ) {
                    Icon(painter = painterResource(id = R.drawable.outline_comment),
                        contentDescription = "",
                        tint = colorResource(
                            id = R.color.my_logo_red
                        ), modifier = Modifier.size(25.dp)
                    )


                }


            }



        }

    }
}




@Composable
fun MySendPostButton(onClick: () -> Unit){
    Surface(
        modifier = Modifier
            .size(50.dp)
            .clickable {
                onClick()
            },
        color = colorResource(id = R.color.my_login_orange),
        shape = CircleShape
    ) {
        Column(modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
            ) {
            Text(text = "+", fontSize = 30.sp, color = colorResource(id = R.color.my_white))
        }

    }
}

@Composable
fun PostComments(name:String,message:String){
    Surface(modifier = Modifier
        .fillMaxWidth(0.8f)
        .height(80.dp), shape = RoundedCornerShape(15.dp),
        color = colorResource(id = R.color.my_platinum)

    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 10.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Text(text = name, fontSize = 22.sp, fontWeight = FontWeight.SemiBold, color = colorResource(
                id = R.color.my_red
            ))
            Text(text = message, fontSize = 19.sp, fontWeight = FontWeight.Light, color = colorResource(
                id = R.color.black
            ))
        }
    }
}

@Composable
fun SelectImage(onClick: () -> Unit){
    Surface(
        modifier = Modifier
            .fillMaxWidth(0.6f)
            .fillMaxHeight(0.4f)
            .clickable {
                onClick()
            }
        ,
        shape = RoundedCornerShape(15.dp),
        color = colorResource(id = R.color.my_platinum)
    ) {
        Column(modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
            ) {
            Text(text = "+", color = colorResource(id = R.color.my_red), fontSize = 100.sp)
            Text(text = "resim ekle", color = colorResource(id = R.color.my_red), fontSize = 22.sp)


        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SendPostTextField(value: MutableState<String>, placeHolder:String){

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth(0.89f)
            .height(150.dp)
        ,
        textStyle = TextStyle(fontSize = 22.sp, color = colorResource(id = R.color.my_red),fontWeight = FontWeight.Light),
        value = value.value,
        onValueChange = {
            // Inside this lambda, 'it' refers to the new value of the text field
            value.value = it
        },
        placeholder = {
            // You can use the 'placeHolder' parameter directly here
            Text(text = placeHolder, fontSize = 22.sp, color = colorResource(id = R.color.my_red), fontWeight = FontWeight.Light, textAlign = TextAlign.Center)
        },
        shape = RoundedCornerShape(20.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = colorResource(id = R.color.black),
            cursorColor = colorResource(id = R.color.my_platinum),
            focusedBorderColor = colorResource(id = R.color.my_platinum),
            unfocusedBorderColor = colorResource(id = R.color.my_platinum),
            containerColor = colorResource(id = R.color.my_platinum)

        ),


    )





}

@Composable
fun MySendPostButton(text:String,onClick: () -> Unit){
    Button(onClick = { onClick() },
        modifier = Modifier
            .fillMaxWidth(0.80f)
            .height(60.dp)
        ,
        colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.my_login_orange)),
        shape = RoundedCornerShape(15.dp)
    ) {
        Text(text = text, fontSize = 25.sp, color = colorResource(id = R.color.my_white), fontWeight = FontWeight.SemiBold )

    }

}
@Composable
fun MyForumPost(navController: NavController,idPP:Int,idQuestion:Int){
    Surface(modifier = Modifier
        .fillMaxWidth(0.9f)
        .fillMaxHeight(0.8f),
        shape = RoundedCornerShape(15.dp),
        color = colorResource(id = R.color.my_platinum)
    ) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()) {
            Row(modifier = Modifier
                .fillMaxHeight(0.15f)
                .fillMaxWidth()
                .padding(start = 10.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(painter = painterResource(id = idPP), contentDescription ="", modifier = Modifier.size(50.dp).clip(shape = CircleShape) )
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = "Onur Alan",
                    color = colorResource(id = R.color.my_red),
                    fontSize = 22.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
            Column(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.8f).padding(top = 5.dp)) {
                Image(painter = painterResource(id = idQuestion),
                    contentDescription ="",
                    modifier = Modifier.fillMaxSize() )
            }
            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(start = 12.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Arkadaslar soruyu yapamadim yardim lazim?",
                    color = colorResource(id = R.color.black),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Light,

                    )
            }
            Row(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(end = 10.dp),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { /*TODO*/ },
                ) {
                    Icon(painter = painterResource(id = R.drawable.arrow_up),
                        contentDescription = "",
                        tint = colorResource(
                            id = R.color.my_logo_red
                        ), modifier = Modifier.size(25.dp)
                    )

                }
                IconButton(onClick = { /*TODO*/ },
                ) {
                    Icon(painter = painterResource(id = R.drawable.arrow_downj),
                        contentDescription = "",
                        tint = colorResource(
                            id = R.color.my_logo_red
                        ), modifier = Modifier.size(25.dp)
                    )


                }

                IconButton(onClick = {
                      CoroutineScope(Dispatchers.IO).launch {

                      }
                      navController.navigate(Screens.ForumAnswerScreen.route)
                },
                ) {
                    Icon(painter = painterResource(id = R.drawable.outline_comment),
                        contentDescription = "",
                        tint = colorResource(
                            id = R.color.my_logo_red
                        ), modifier = Modifier.size(25.dp)
                    )


                }


            }



        }

    }
}
@Composable
fun ForumAnswers(name:String,message:String){
    Surface(modifier = Modifier
        .fillMaxWidth(0.8f)
        .height(80.dp), shape = RoundedCornerShape(15.dp),
        color = colorResource(id = R.color.my_platinum)

    ) {
        Row (modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically){
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(0.8f)
                    .padding(start = 10.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.SpaceAround
            ) {
                Text(text = name, fontSize = 22.sp, fontWeight = FontWeight.SemiBold, color = colorResource(
                    id = R.color.my_red
                ))
                Text(text = message, fontSize = 19.sp, fontWeight = FontWeight.Light, color = colorResource(
                    id = R.color.black
                ))
            }
            Row(modifier = Modifier
                .fillMaxSize()
                .padding(end = 10.dp), horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically) {
                Surface(modifier = Modifier.size(30.dp), shape = RoundedCornerShape(15.dp), border = BorderStroke(width = 1.dp, color = colorResource(
                    id = R.color.my_red
                ))) {
                    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                        Text(text = "...", color = colorResource(id = R.color.my_red), fontSize = 15.sp, modifier = Modifier.padding(bottom = 3.dp))
                    }

                }


            }

        }

    }
}
@Composable
fun MyCourseBox(navController: NavController,questionID:Int,instName:String,konu:String,onClick: () -> Unit){
    Surface(modifier = Modifier
        .fillMaxWidth(0.9f)
        .height(150.dp).clickable {
            onClick()
        },
        color = colorResource(id = R.color.my_platinum),
        shape = RoundedCornerShape(15.dp),
        ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 10.dp, vertical = 10.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.8f),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Column(modifier = Modifier
                    .fillMaxWidth(0.25f)
                    .fillMaxHeight(), horizontalAlignment = Alignment.Start, verticalArrangement =Arrangement.Center ) {
                    Surface(
                        modifier = Modifier.fillMaxWidth(),
                        color = colorResource(id = R.color.my_platinum),
                    ) {
                        Image(painter = painterResource(id = questionID), contentDescription = "", modifier = Modifier.fillMaxSize())
                    }
                }
                Spacer(modifier = Modifier.width(10.dp))

                Column(modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(top = 8.dp), horizontalAlignment = Alignment.Start, verticalArrangement =Arrangement.Top ) {
                    Text(text = konu, fontSize = 23.sp, fontWeight = FontWeight.SemiBold, color = colorResource(
                        id = R.color.my_red
                    ))
                    Text(text = instName, fontSize = 20.sp, fontWeight = FontWeight.Normal, color = colorResource(
                        id = R.color.my_red
                    ))

                }

            }
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(horizontal = 10.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ){
                Row(modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .fillMaxHeight(), horizontalArrangement = Arrangement.Start,verticalAlignment = Alignment.CenterVertically) {
                    Text(text = "750MP", fontSize = 23.sp, fontWeight = FontWeight.SemiBold, color = colorResource(
                        id = R.color.my_red
                    ))
                }
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(), horizontalArrangement = Arrangement.End, verticalAlignment = Alignment.CenterVertically) {
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

        }

    }
}
@Composable
fun MyBuyButton(text:String,onClick: () -> Unit){
    Button(onClick = { onClick() },
        modifier = Modifier
            .fillMaxWidth(0.80f)
            .height(60.dp)
            .padding(bottom = 10.dp)
        ,
        colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.my_login_orange)),
        shape = RoundedCornerShape(15.dp)
    ) {
        Text(text = text, fontSize = 25.sp, color = colorResource(id = R.color.my_white), fontWeight = FontWeight.SemiBold )
    }

}
@Composable
fun MyEditProfileButton(text:String,onClick: () -> Unit){
    Button(onClick = { onClick() },
        modifier = Modifier
            .fillMaxWidth(0.90f)
            .height(45.dp)
            .padding(bottom = 10.dp)
        ,
        colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.my_platinum)),
        shape = RoundedCornerShape(15.dp)
    ) {
        Text(text = text, fontSize = 15.sp, color = colorResource(id = R.color.black), fontWeight = FontWeight.Light )
    }

}

@Composable
fun MyDumyPost(
    viewModel: MarathonViewModel,
    navController: NavController,
    name:String,
    bio:String,
    postImage: Painter,
    userPP: Painter,
){
    Surface(modifier = Modifier
        .fillMaxWidth(0.9f)
        .fillMaxHeight(0.8f),
        shape = RoundedCornerShape(15.dp),
        color = colorResource(id = R.color.my_platinum)
    ) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()) {
            Row(modifier = Modifier
                .fillMaxHeight(0.15f)
                .fillMaxWidth()
                .padding(start = 10.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Image(painter = userPP, contentDescription ="", modifier = Modifier
                    .size(30.dp)
                    .clip(shape = CircleShape) )
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = name,
                    color = colorResource(id = R.color.my_red),
                    fontSize = 22.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
            Column(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.8f)) {
                Image(painter = postImage,
                    contentDescription ="",
                    modifier = Modifier.fillMaxSize() )
            }
            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(start = 12.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = bio,
                    color = colorResource(id = R.color.black),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Light,

                    )
            }
            Row(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(end = 10.dp),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { /*TODO*/ },
                ) {
                    Icon(painter = painterResource(id = R.drawable.outlined_favorite),
                        contentDescription = "",
                        tint = colorResource(
                            id = R.color.my_logo_red
                        ), modifier = Modifier.size(25.dp)
                    )

                }

                IconButton(onClick = {
                    navController.navigate(Screens.PostCommentScreen.route)
                },
                ) {

                    Icon(painter = painterResource(id = R.drawable.outline_comment),
                        contentDescription = "",
                        tint = colorResource(
                            id = R.color.my_logo_red
                        ), modifier = Modifier.size(25.dp)
                    )


                }


            }



        }

    }
}






