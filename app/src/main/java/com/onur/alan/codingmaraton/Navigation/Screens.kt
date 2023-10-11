package com.onur.alan.codingmaraton.Navigation

sealed class Screens(val route: String){
    object LoginScreen: Screens("main_screen")
    object RegisterScreen: Screens("register_screen")
    object CourseMainScreen: Screens("course_main_screen")
    object CoursesScreen: Screens("courses_screen")
    object ForumAnswerScreen: Screens("forum_answer_screen")
    object ForumMainScreen: Screens("forum_main_screen")
    object PostCommentScreen: Screens("post_comment_screen")
    object PostFeedScreen: Screens("post_feed_screen")
    object ProfileEditScreen: Screens("profile_edit_screen")
    object ProfileScreen: Screens("profile_screen")
    object SendPostScreen: Screens("send_post_screen")
    object SendQuestionScreen: Screens("send_question_screen")

    object WatchCourseScreen: Screens("watch_course_screen")


}

