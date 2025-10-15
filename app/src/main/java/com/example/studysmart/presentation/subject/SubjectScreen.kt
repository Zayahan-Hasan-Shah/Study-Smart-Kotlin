package com.example.studysmart.presentation.subject

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.studysmart.destinations.TaskScreenRouteDestination
import com.example.studysmart.destinations.TaskScreenRouteDestination.invoke
import com.example.studysmart.domain.model.Session
import com.example.studysmart.domain.model.Subject
import com.example.studysmart.domain.model.Task
import com.example.studysmart.presentation.components.AddSubjectDialog
import com.example.studysmart.presentation.components.CountCard
import com.example.studysmart.presentation.components.DeleteDialog
import com.example.studysmart.presentation.components.studySeesionsList
import com.example.studysmart.presentation.components.tasksList
import com.example.studysmart.presentation.task.TaskScreenNavArgs
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator


data class SubjectScreenNavArgs(
    val subjectId: Int,
)

@Destination(navArgsDelegate = SubjectScreenNavArgs::class)
@Composable
fun SubjectScreenRoute(
    navigator: DestinationsNavigator
){
    SubjectScreen(
        onBackButtonClick = {navigator.navigateUp()},
        onAddTaskButtonClick = {
            val navArgs = TaskScreenNavArgs(taskId = null, subjectId = null)
            navigator.navigate(TaskScreenRouteDestination(navArgs = navArgs))
        },
        onTaskCardClick = {taskId ->
            val navArgs = TaskScreenNavArgs(taskId = taskId, subjectId = null)
            navigator.navigate(TaskScreenRouteDestination(navArgs = navArgs))}
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun SubjectScreen(
    onBackButtonClick: () -> Unit,
    onAddTaskButtonClick: () -> Unit,
    onTaskCardClick: (Int?) -> Unit,
){


    var isAddSubjectDialogOpen by rememberSaveable { mutableStateOf(false) }
    var isEditSubjectDialogOpen by rememberSaveable { mutableStateOf(false) }
    var isDeleteDialogOpen by rememberSaveable { mutableStateOf(false) }
    var isDeleteSubjectDialogOpen by rememberSaveable { mutableStateOf(false) }
    var isDeleteSessionDialogOpen by rememberSaveable { mutableStateOf(false) }

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
        isOpen = isDeleteSubjectDialogOpen,
        title = "Delete Subject",
        bodyText = "Are you sure?",
        onDismissRequest = {isDeleteSubjectDialogOpen = false},
        onConfirmButtonClick = {isDeleteSubjectDialogOpen = false}
    )


    DeleteDialog(
        isOpen = isDeleteDialogOpen,
        title = "Delete Session",
        bodyText = "Are you sure?",
        onDismissRequest = {isDeleteDialogOpen = false},
        onConfirmButtonClick = {isDeleteDialogOpen = false}
    )
    val listState = rememberLazyListState()
    val isFABExpanded by remember {
        derivedStateOf { listState.firstVisibleItemIndex == 0 }
    }
    val scrollBehaviour = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()
    Scaffold (
        modifier = Modifier.nestedScroll(scrollBehaviour.nestedScrollConnection),
        topBar = {
            SubjectScreenTopBar(
                title = "DSA",
                onBackButtonClick = onBackButtonClick,
                onEditButtonClick = {isEditSubjectDialogOpen=true},
                onDeleteButtonClick = { isDeleteSubjectDialogOpen= true},
                scrollBehaviour = scrollBehaviour,
            )
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = onAddTaskButtonClick,
                icon = { Icon(imageVector = Icons.Default.Add, contentDescription = "Add")},
                text = {Text(text="Add Task")},
                expanded = isFABExpanded
            )
        }
    ) { paddingValue ->
        LazyColumn (
            state = listState,
            modifier = Modifier.fillMaxSize().padding(paddingValue)
        ) {
            item {
                SubjectOverviewSection(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    studiedHours = "10",
                    goalHours = "15",
                    progress = 0.75f
                )
            }
            tasksList(
                sectionTitle = "UPCOMING TASKS",
                emptyListText = "You don't have any upcoming task.\nClick on the + button to add new task",
                tasks = tasksList,
                onCheckBoxClick = {},
                onTaskCardClick = onTaskCardClick,
            )
            item {
                Spacer(modifier = Modifier.height(20.dp))
            }
            tasksList(
                sectionTitle = "COMPLETED TASKS",
                emptyListText = "You don't have any completed task.\nClick the check box on completion of task",
                tasks = tasksList,
                onCheckBoxClick = {},
                onTaskCardClick = onTaskCardClick,
            )
            item {
                Spacer(modifier = Modifier.height(20.dp))
            }
            studySeesionsList(
                sectionTitle = "RECENT STUDY LIST",
                emptyListText = "You don't have any recent study sessions.\nStart a study session to begin recording your progress",
                sessions = studySessionList,
                onDeleteIconClick = { isDeleteSessionDialogOpen=true}
            )
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun SubjectScreenTopBar(
    title: String,
    onBackButtonClick: () -> Unit,
    onDeleteButtonClick: () -> Unit,
    onEditButtonClick: () -> Unit,
    scrollBehaviour: TopAppBarScrollBehavior,
) {
    LargeTopAppBar(
        scrollBehavior = scrollBehaviour,
        navigationIcon = {
            IconButton(
                onClick = onBackButtonClick
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Navigate Back",
                )
            }
        },
        title = {
            Text(
                text = title,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.headlineSmall
            )
        },
        actions = {
            IconButton(
                onClick = onDeleteButtonClick
            ) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Delete Subject",
                )
            }
            IconButton(
                onClick = onEditButtonClick
            ) {
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = "Edit Subject",
                )
            }
        },
        modifier = Modifier
    )
}


@Composable
private fun SubjectOverviewSection(
    modifier : Modifier,
    studiedHours: String,
    goalHours: String,
    progress: Float
){
    val percentageProgress = remember (progress) {
        (progress * 100).toInt().coerceIn(0,100)
    }
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        CountCard(
            modifier = Modifier.weight(1f),
            headingText = "Goal Study Hours",
            count = goalHours,
        )
        Spacer(modifier = Modifier.width(10.dp))
        CountCard(
            modifier = Modifier.weight(1f),
            headingText = "Study Hours",
            count = studiedHours,
        )
        Spacer(modifier = Modifier.width(10.dp))
        Box(
            modifier = Modifier.size(75.dp),
            contentAlignment = Alignment.Center
        ){
            CircularProgressIndicator(
                modifier = Modifier.fillMaxSize(),
                progress = 1f,
                strokeWidth = 4.dp,
                strokeCap = StrokeCap.Round,
                color = MaterialTheme.colorScheme.surfaceVariant
            )
            CircularProgressIndicator(
                modifier = Modifier.fillMaxSize(),
                progress = progress,
                strokeWidth = 4.dp,
                strokeCap = StrokeCap.Round,
                color = MaterialTheme.colorScheme.surfaceVariant
            )
            Text(text = "$percentageProgress%")
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