package com.vixiloc.vtodo.ui.feature.home.composables

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import com.vixiloc.vtodo.data.model.Task
import com.vixiloc.vtodo.ui.theme.VTodoTheme

class HomeScreen : Screen {
    @Composable
    override fun Content() {
        Home()
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Home(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(14.dp)
    ) {
        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.CenterEnd) {
            Button(onClick = { /*TODO*/ }, shape = MaterialTheme.shapes.small) {
                Text(text = "Create New Task")
                Icon(imageVector = Icons.Outlined.Add, contentDescription = null)
            }
        }

        LazyColumn {
            stickyHeader {
                Text(
                    modifier = Modifier.padding(bottom = 12.dp),
                    text = "Pending",
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
                )
            }
            items(5) {
                TaskItem(
                    modifier = Modifier.padding(bottom = 9.dp),
                    data = Task().apply {
                        name = "Task $it"
                    }
                )
            }
            stickyHeader {
                Text(
                    modifier = Modifier.padding(bottom = 12.dp),
                    text = "Completed",
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
                )
            }
            items(5) {
                TaskItem(
                    modifier = Modifier.padding(bottom = 9.dp),
                    data = Task().apply {
                        name = "Task $it"
                    }
                )
            }
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