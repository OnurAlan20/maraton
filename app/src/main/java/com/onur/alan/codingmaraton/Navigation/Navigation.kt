package com.onur.alan.codingmaraton.Navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.onur.alan.codingmaraton.screens.CourseMainScreen
import com.onur.alan.codingmaraton.screens.CoursesScreen
import com.onur.alan.codingmaraton.screens.ForumAnswerScreen
import com.onur.alan.codingmaraton.screens.ForumMainScreen
import com.onur.alan.codingmaraton.screens.LoginScreen
import com.onur.alan.codingmaraton.screens.MarathonViewModel
import com.onur.alan.codingmaraton.screens.PostCommentScreen
import com.onur.alan.codingmaraton.screens.PostFeedScreen
import com.onur.alan.codingmaraton.screens.ProfileEditScreen
import com.onur.alan.codingmaraton.screens.ProfileScreen
import com.onur.alan.codingmaraton.screens.RegisterScreen
import com.onur.alan.codingmaraton.screens.SendPostScreen
import com.onur.alan.codingmaraton.screens.SendQuestionScreen

@Composable
fun Navigation(viewModel: MarathonViewModel, navController: NavHostController){

    NavHost(navController = navController, startDestination = Screens.LoginScreen.route, builder = {
        composable(route = Screens.LoginScreen.route ){
            LoginScreen(viewModel = viewModel,navController)
        }
        composable(route = Screens.RegisterScreen.route ){
            RegisterScreen(viewModel = viewModel,navController)
        }
        composable(route = Screens.CourseMainScreen.route ){
            CourseMainScreen(viewModel = viewModel,navController)
        }
        composable(route = Screens.ForumAnswerScreen.route ){
            ForumAnswerScreen(viewModel = viewModel,navController)
        }
        composable(route = Screens.ForumMainScreen.route ){
            ForumMainScreen(viewModel = viewModel, navController)
        }
        composable(route = Screens.PostCommentScreen.route ){
            PostCommentScreen(viewModel = viewModel,navController)
        }
        composable(route = Screens.PostFeedScreen.route ){
            PostFeedScreen(viewModel = viewModel,navController)
        }
        composable(route = Screens.ProfileEditScreen.route ){
            ProfileEditScreen(viewModel = viewModel,navController)
        }
        composable(route = Screens.SendPostScreen.route ){
            SendPostScreen(viewModel = viewModel,navController)
        }
        composable(route = Screens.CoursesScreen.route ){
            CoursesScreen(viewModel = viewModel,navController)
        }
        composable(route = Screens.ProfileScreen.route ){
            ProfileScreen(viewModel = viewModel,navController)
        }
        composable(route = Screens.SendQuestionScreen.route ){
            SendQuestionScreen(viewModel = viewModel,navController)
        }





    })


}