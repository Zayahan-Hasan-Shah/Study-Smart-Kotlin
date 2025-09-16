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
import androidx.compose.foundation.layout.size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import com.example.studysmart.R


@Composable
fun DashboardScreen(){
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
    subjectList: List<Subject>
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
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add Subjects"
                )
            }
        }
        if( subjectList.isEmpty()){
            Image(
                modifier = Modifier.size(120.dp).align(Alignment.CenterHorizontally),
                painter = painterResource(R.drawable.ic_launcher_background),
                contentDescription = ""
            )
            Text(modifier = Modifier.fillMaxWidth(), text="", style = MaterialTheme.typography.bodySmall, color = Color.Gray, textAlign = TextAlign.Center
            )
        }
    }
}