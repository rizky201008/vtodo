package com.vixiloc.vtodo.ui.feature.create_task.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBackIosNew
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import com.vixiloc.vtodo.R
import com.vixiloc.vtodo.ui.feature.common.VButton
import com.vixiloc.vtodo.ui.feature.common.VTextField
import com.vixiloc.vtodo.ui.theme.VTodoTheme

class CreateTaskScreen : Screen {
    @Composable
    override fun Content() {
        CreateTask()
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateTask(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = { /*TODO*/ },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.White),
                navigationIcon = {
                    IconButton(
                        onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Outlined.ArrowBackIosNew,
                            contentDescription = "back button",
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                })
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(14.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .background(
                        color = MaterialTheme.colorScheme.primary,
                        shape = MaterialTheme.shapes.medium
                    )
                    .padding(10.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.icons8_task_100),
                    contentDescription = null,
                    modifier = Modifier.size(50.dp)
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            var value by remember {
                mutableStateOf(TextFieldValue("Now we'll add the decoration box to give it a more personalized appearance."))
            }

            VTextField(
                label = "Task name",
                value = value,
                onValueChange = { value = it },
                maxLines = 1,
                singleLine = false
            )
            Spacer(modifier = Modifier.height(12.dp))
            VTextField(
                label = "Task description",
                value = value,
                onValueChange = { value = it },
                maxLines = 5,
                singleLine = false
            )
            Spacer(modifier = Modifier.height(23.dp))
            VButton(onClick = {}, label = "Save Task", modifier = Modifier.fillMaxWidth())
        }
    }
}

@Preview
@Composable
private fun CreateTaskPreview() {
    VTodoTheme(darkTheme = false) {
        Surface(color = Color(0xFFf4f4f4)) {
            CreateTask()
        }
    }
}