package com.example.studysmart.dashboard
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.material3.Scaffold
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.studysmart.presentation.components.CountCard
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.filled.Add
import com.example.studysmart.domain.model.Subject
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import com.example.studysmart.R
import com.example.studysmart.domain.model.Session
import com.example.studysmart.domain.model.Task
import com.example.studysmart.presentation.components.AddSubjectDialog
import com.example.studysmart.presentation.components.SubjectCard
import com.example.studysmart.presentation.components.studySeesionsList
import com.example.studysmart.presentation.components.tasksList
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import com.example.studysmart.presentation.components.DeleteDialog

@Composable
fun DashboardScreen(){

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

    var isAddSubjectDialogOpen by rememberSaveable { mutableStateOf(false) }
    var isDeleteDialogOpen by rememberSaveable { mutableStateOf(false) }

    var subjectName by remember { mutableStateOf("")}
    var goalHours by remember { mutableStateOf("")}
    var selectedColors by remember {mutableStateOf(Subject.subjectCardColor.random())}

    AddSubjectDialog(
        isOpen = isAddSubjectDialogOpen,
        onDismissRequest = {isAddSubjectDialogOpen = false},
        onConfirmButtonClick = {isAddSubjectDialogOpen = false},
        subjectName = subjectName,
        goalHours = goalHours,
        onSubjectNameChange = {subjectName = it},
        onGoalHoursChange = {goalHours = it},
        title = "",
        onColorChange = {selectedColors = it},
        selectedColors = selectedColors,
    )

    DeleteDialog(
        isOpen = isDeleteDialogOpen,
        title = "Delete Session",
        bodyText = "Are you sure?",
        onDismissRequest = {isDeleteDialogOpen = false},
        onConfirmButtonClick = {isDeleteDialogOpen = false}
    )

    Scaffold (
        topBar = {DashboardScreenTopBar()}
    ) {
    paddingValues ->
        LazyColumn (
                modifier = Modifier.fillMaxSize().padding(paddingValues)
        ) {
            item {
                CountCardSection(
                    modifier = Modifier.fillMaxWidth().padding(12.dp), subjectCount = 5,
                    studiedHour = "10",
                    goalHours = "15" )
            }
            item {
                SubjectCardsSection(modifier = Modifier.fillMaxWidth().padding(12.dp), subjectList = subjects, onAddIconClicked = {isAddSubjectDialogOpen = true} )
            }
            item {
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal= 48.dp, vertical=20.dp),
                    onClick = {}
                ) {
                    Text(
                        text = "Start Study Session"
                    )
                }
            }
            tasksList(
                sectionTitle = "UPCOMING TASKS",
                emptyListText = "You don't have any upcoming task.\nClick on the + button to add new task",
                tasks = tasksList,
                onCheckBoxClick = {},
                onTaskCardClick = {},
                )
            item {
                Spacer(modifier = Modifier.height(20.dp))
            }
            studySeesionsList(
                        sectionTitle = "RECENT STUDY LIST",
                emptyListText = "You don't have any recent study sessions.\nStart a study session to begin recording your progress",
                sessions = studySessionList,
                onDeleteIconClick = {isDeleteDialogOpen= true   }
            )

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun DashboardScreenTopBar(){
    CenterAlignedTopAppBar(
        title = {
            Text(
                text="StudySmart",
                style= MaterialTheme.typography.headlineMedium)
        }
    )
}

@Composable
private fun CountCardSection(
    modifier: Modifier,
    subjectCount: Int,
    studiedHour: String,
    goalHours: String
){
    Row ( modifier = modifier ) {
        CountCard(modifier = Modifier.weight(1f), headingText = "Subject Count", count = "$subjectCount")
        Spacer(modifier = Modifier.width((10.dp)))
        CountCard(modifier = Modifier.weight(1f), headingText = "Studied Hours", count = studiedHour)
        Spacer(modifier = Modifier.width((10.dp)))
        CountCard(modifier = Modifier.weight(1f), headingText = "Goal Study Hours", count = goalHours)
        Spacer(modifier = Modifier.width((10.dp)))
    }
}

@Composable
private fun SubjectCardsSection(
    modifier: Modifier,
    subjectList: List<Subject>,
    emptyListText: String = "You don't have any subject.\nClick the + button to add new subject.",
    onAddIconClicked: () -> Unit,
){
    Column ( modifier = Modifier ) {
        Row (
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text(
                text = "SUBJECTS",
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(start = 12.dp)
            )
            IconButton(onClick = onAddIconClicked) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add Subjects"
                )
            }
        }
        if( subjectList.isEmpty()){
            Image(
                modifier = Modifier.size(120.dp).align(Alignment.CenterHorizontally),
                painter = painterResource(R.drawable.img_books),
                contentDescription = emptyListText
            )
            Text(modifier = Modifier.fillMaxWidth(),
                text= emptyListText,
                style = MaterialTheme.typography.bodySmall,
                color = Color.Gray,
                textAlign = TextAlign.Center
            )
        }
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(start = 12.dp, end = 12.dp)
        ) {
            items(subjectList) {subject ->
                SubjectCard(
                    subjectName = subject.name,
                    gradientColors = subject.colors,
                    onClick = {}
                )
            }
        }
    }
}