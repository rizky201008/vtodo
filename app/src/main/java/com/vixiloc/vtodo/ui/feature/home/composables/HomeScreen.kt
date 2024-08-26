package com.vixiloc.vtodo.ui.feature.home.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import com.vixiloc.vtodo.ui.feature.common.VTfSearch
import com.vixiloc.vtodo.ui.feature.home.HomeContract
import com.vixiloc.vtodo.ui.feature.home.HomeViewModel
import com.vixiloc.vtodo.ui.theme.VTodoTheme
import org.koin.androidx.compose.koinViewModel

class HomeScreen : Screen {
    @Composable
    override fun Content() {
        Home()
    }
}

@Composable
fun Home(modifier: Modifier = Modifier) {
    val viewModel: HomeViewModel = koinViewModel()
    val state = viewModel.state.value
    val onEvent = viewModel::onEvent

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    onEvent(HomeContract.Event.ShowAddTodo(true))
                },
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.padding(10.dp)
                ) {
                    Text(
                        text = "Create",
                        style = MaterialTheme.typography.titleSmall
                    )
                    Icon(
                        imageVector = Icons.Outlined.Add,
                        contentDescription = "Add button"
                    )
                }
            }
        }
    ) { padding ->
        Column(
            modifier = modifier
                .padding(padding)
                .fillMaxSize()
                .padding(14.dp)
        ) {
            VTfSearch(
                value = state.searchValue,
                onValueChange = {
                    onEvent(
                        HomeContract.Event.ChangeInput(
                            HomeContract.InputName.Search,
                            it
                        )
                    )
                },
            )

            Spacer(modifier = Modifier.height(10.dp))

            LazyColumn {
                items(items = state.todos, key = { it._id.toString() }) { todo ->
                    TodoItem(
                        todo = todo,
                        modifier = Modifier.padding(bottom = 10.dp),
                        changeChecked = {
                            onEvent(HomeContract.Event.ChangeTodoStatus(it))
                        },
                        onClick = {
                            onEvent(HomeContract.Event.ShowEditTodo(true, it))
                        }
                    )
                }
            }

            CreateUpdateDialog(viewModel = viewModel)
        }
    }
}

@Preview
@Composable
private fun HomePreview() {
    VTodoTheme(darkTheme = false) {
        Surface(color = Color(0xFFf4f4f4)) {
            Home()
        }
    }
}