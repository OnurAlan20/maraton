package com.onur.alan.codingmaraton

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.onur.alan.codingmaraton.Navigation.Navigation
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
import com.onur.alan.codingmaraton.screens.WatchCourseScreen
import com.onur.alan.codingmaraton.screens.YoutubeVideoPlayer
import com.onur.alan.codingmaraton.ui.theme.CodingMaratonTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    val bcv = MarathonViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CoroutineScope(Dispatchers.IO).launch {
            bcv.initRetrofit()

        }
        setContent {
            val navController = rememberNavController()


            //WatchCourseScreen(viewModel = bcv, navController = navController)
            
            Navigation(viewModel = bcv, navController = navController)
            //PostFeedScreen(viewModel = bcv, navController =navController )

        }
    }
}


