package com.example.studysmart.presentation.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable

@Composable
fun DeleteDialog(
    isOpen: Boolean,
    title: String,
    onDismissRequest: () -> Unit,
    onConfirmButtonClick: () -> Unit,
    bodyText: String,
){

    if(isOpen){
        AlertDialog(
            onDismissRequest = onDismissRequest,
            title = { Text(text = title) },
            text = {
                Text(text = bodyText)
            },
            confirmButton = {
                TextButton(
                    onClick = onConfirmButtonClick,
                ) {
                    Text(text= "DELETE")

                }
            },
            dismissButton = {
                TextButton(onClick = onDismissRequest) {
                    Text(text= "CANCEL")
                }
            }
        )
    }


}
