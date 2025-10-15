package com.example.studysmart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraph
import com.example.studysmart.domain.model.Session
import com.example.studysmart.domain.model.Subject
import com.example.studysmart.domain.model.Task
import com.example.studysmart.ui.theme.StudysmartTheme
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.spec.NavGraphSpec

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StudysmartTheme {
//                DashboardScreen()
//                SubjectScreen()
//                TaskScreen()
//                SessionScreen()
                DestinationsNavHost(navGraph = NavGraphs.root)
            }
        }
    }
}

val subjects = listOf(
    Subject(name = "English", goalHours = 10f, colors = Subject.subjectCardColor[0], subjectId = 0),
    Subject(name = "Computer", goalHours = 10f, colors = Subject.subjectCardColor[1], subjectId = 0),
    Subject(name = "Physics", goalHours = 10f, colors = Subject.subjectCardColor[2], subjectId = 0),
    Subject(name = "Geology", goalHours = 10f, colors = Subject.subjectCardColor[3], subjectId = 0),
    Subject(name = "Fine Arts", goalHours = 10f, colors = Subject.subjectCardColor[4], subjectId = 0),
)

val tasksList = listOf(
    Task(
        title = "Write an Essay",
        description = "",
        dueDate = 0L,
        priority = 0,
        relatedToSubject = "",
        isComplete = false,
        taskId = 1,
        taskSubjectId = 0
    ),
    Task(
        title = "Learn Kotlin",
        description = "",
        dueDate = 0L,
        priority = 1,
        relatedToSubject = "",
        isComplete = false,
        taskId = 1,
        taskSubjectId = 0
    ),
    Task(
        title = "Kill Einstein",
        description = "",
        dueDate = 0L,
        priority = 2,
        relatedToSubject = "",
        isComplete = true,
        taskId = 1,
        taskSubjectId = 0
    ),
    Task(
        title = "Do work",
        description = "",
        dueDate = 0L,
        priority = 1,
        relatedToSubject = "",
        isComplete = false,
        taskId = 1,
        taskSubjectId = 0
    ),
    Task(
        title = "Play Games",
        description = "",
        dueDate = 0L,
        priority = 0,
        relatedToSubject = "",
        isComplete = true,
        taskId = 1,
        taskSubjectId = 0
    ),
)

val studySessionList = listOf(
    Session(
        relatedToSubject = "Computer",
        date = 0L,
        duration = 2,
        sessionSubjectId = 0,
        sessionId = 0,
    ),
    Session(
        relatedToSubject = "Computer",
        date = 0L,
        duration = 2,
        sessionSubjectId = 0,
        sessionId = 0,
    ),
    Session(
        relatedToSubject = "Fine Arts",
        date = 0L,
        duration = 2,
        sessionSubjectId = 0,
        sessionId = 0,
    ),
    Session(
        relatedToSubject = "Physics",
        date = 0L,
        duration = 2,
        sessionSubjectId = 0,
        sessionId = 0,
    ),
    Session(
        relatedToSubject = "Geology",
        date = 0L,
        duration = 2,
        sessionSubjectId = 0,
        sessionId = 0,
    ),
    Session(
        relatedToSubject = "Android Studio",
        date = 0L,
        duration = 2,
        sessionSubjectId = 0,
        sessionId = 0,
    ),
)