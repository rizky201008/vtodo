package com.vixiloc.vtodo.ui.feature.home.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.vixiloc.vtodo.ui.feature.common.VButton
import com.vixiloc.vtodo.ui.feature.common.VTextField
import com.vixiloc.vtodo.ui.feature.home.HomeContract
import com.vixiloc.vtodo.ui.feature.home.HomeViewModel

@Composable
fun CreateUpdateDialog(modifier: Modifier = Modifier, viewModel: HomeViewModel) {
    val state = viewModel.state.value
    val onEvent = viewModel::onEvent

    if (state.showAddTodo) {
        Dialog(onDismissRequest = {
            onEvent(HomeContract.Event.ShowAddTodo(false))
            onEvent(HomeContract.Event.ClearInputs)
        }) {
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .background(color = Color(0xFFF4F4F4), shape = MaterialTheme.shapes.small)
                    .border(
                        width = 3.dp,
                        color = MaterialTheme.colorScheme.primary,
                        shape = MaterialTheme.shapes.small
                    )
                    .padding(12.dp)
            ) {
                Row(horizontalArrangement = Arrangement.End, modifier = Modifier.fillMaxWidth()) {
                    IconButton(onClick = {
                        onEvent(HomeContract.Event.ShowAddTodo(false))
                        onEvent(HomeContract.Event.ClearInputs)
                    }) {
                        Icon(
                            imageVector = Icons.Outlined.Close,
                            contentDescription = "Close dialog",
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                }

                VTextField(
                    modifier = Modifier.padding(bottom = 10.dp),
                    label = "Todo name",
                    value = state.inputTodoName,
                    onValueChange = {
                        onEvent(
                            HomeContract.Event.ChangeInput(
                                HomeContract.InputName.TodoName,
                                it
                            )
                        )
                    }
                )

                VButton(label = "Save", onClick = {
                    onEvent(HomeContract.Event.ShowAddTodo(false))
                    onEvent(HomeContract.Event.Save)
                }, modifier = Modifier.fillMaxWidth())
            }
        }
    }
}