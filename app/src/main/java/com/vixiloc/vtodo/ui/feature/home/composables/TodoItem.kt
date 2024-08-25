package com.vixiloc.vtodo.ui.feature.home.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.vixiloc.vtodo.data.model.Todo

@Composable
fun TodoItem(
    modifier: Modifier = Modifier,
    todo: Todo,
    changeChecked: (Todo) -> Unit
) {
    val textStyle =
        if (todo.completed) MaterialTheme.typography.bodyMedium.copy(textDecoration = TextDecoration.LineThrough) else MaterialTheme.typography.bodyMedium
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(color = Color.White, shape = MaterialTheme.shapes.small)
            .padding(vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(checked = todo.completed, onCheckedChange = { changeChecked(todo) })
        Spacer(modifier = Modifier.width(10.dp))
        Text(text = todo.name, style = textStyle)
    }
}