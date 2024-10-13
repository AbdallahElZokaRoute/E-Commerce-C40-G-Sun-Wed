package com.route.e_commercec40gsunwed.view.composable

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.route.e_commercec40gsunwed.R
import com.route.e_commercec40gsunwed.ui.theme.Blue

@Composable
fun ErrorDialog(errorState: MutableState<String>, modifier: Modifier = Modifier) {
    if (errorState.value.isNotEmpty())
        AlertDialog(
            onDismissRequest = {
                errorState.value = ""
            }, confirmButton = {
                TextButton(onClick = {
                    errorState.value = ""
                }) {
                    Text(text = stringResource(R.string.ok), color = Blue)
                }
            }, text = {
                Text(text = errorState.value)
            }
        )
}

