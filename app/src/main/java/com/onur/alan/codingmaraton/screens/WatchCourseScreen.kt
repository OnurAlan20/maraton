package com.onur.alan.codingmaraton.screens

import android.webkit.WebView
import android.webkit.WebViewClient
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
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import com.onur.alan.codingmaraton.R
import com.onur.alan.codingmaraton.components.MyBottomAppBar
import com.onur.alan.codingmaraton.components.MyForumPost
import com.onur.alan.codingmaraton.components.MySendPostButton



@Composable
fun WatchCourseScreen(viewModel: MarathonViewModel,navController: NavController){
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
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Top
            ) {
                Divider(thickness = 2.dp, color = colorResource(id = R.color.my_logo_red), modifier = Modifier.fillMaxWidth())
                Spacer(modifier = Modifier.height(10.dp))
                YoutubeVideoPlayer(videoId = "fhMjK04qGzw")
                Text(text = "15 SAAT'DE ÜÇGENLER",
                    color = colorResource(id = R.color.my_red),
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 22.sp,
                    modifier = Modifier.padding(start = 10.dp)
                    )
                Spacer(modifier = Modifier.height(5.dp))
                Text(text = "Kübra Bilgiç",
                    color = colorResource(id = R.color.black),
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(start = 10.dp)

                )
                Spacer(modifier = Modifier.height(10.dp))

                Row (modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp)){
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
                Column(modifier = Modifier.fillMaxHeight().padding(start = 10.dp), horizontalAlignment = Alignment.Start, verticalArrangement = Arrangement.Top) {
                    Text(text = """
  1. Üçgenlerde Açılar
  2. Üçgenlerde Uzunluklar
  3. Eşkenar Üçgen
  4. İkizkenar Üçgen
  5. Muhteşem Üçlü""", color = colorResource(id = R.color.black), fontSize = 18.sp, fontWeight = FontWeight.Light)
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
@Composable
fun YoutubeVideoPlayer(videoId: String) {
    val webView = WebView(LocalContext.current).apply {
        settings.javaScriptEnabled = true
        settings.loadWithOverviewMode = true
        settings.useWideViewPort = true
        webViewClient = WebViewClient()
    }

    val htmlData = getHTMLData(videoId)

    Column(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.5f)) {

        AndroidView(modifier = Modifier.fillMaxWidth(),factory = { webView }) { view ->
            view.loadDataWithBaseURL(
                "https://www.youtube.com/",
                htmlData,
                "text/html",
                "UTF-8",
                null
            )
        }


    }
}

fun getHTMLData(videoId: String): String {
    return """
        <html>

            <body style="margin:0px;padding:0px;">
               <div id="player"></div>
                <script>
                    var player;
                    function onYouTubeIframeAPIReady() {
                        player = new YT.Player('player', {
                            height: '800',
                            width: '1200',
                            videoId: '$videoId',
                            playerVars: {
                                'playsinline': 1
                            },
                            events: {
                                'onReady': onPlayerReady
                            }
                        });
                    }
                    function onPlayerReady(event) {
                     player.playVideo();
                        // Player is ready
                    }
                    function seekTo(time) {
                        player.seekTo(time, true);
                    }
                      function playVideo() {
                        player.playVideo();
                    }
                    function pauseVideo() {
                        player.pauseVideo();
                    }
                </script>
                <script src="https://www.youtube.com/iframe_api"></script>
            </body>
        </html>
    """.trimIndent()
}


