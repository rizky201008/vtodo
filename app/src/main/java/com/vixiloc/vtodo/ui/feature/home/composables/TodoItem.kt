package com.vixiloc.vtodo.ui.feature.home.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.Delete
import androidx.compose.material.icons.twotone.Done
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.vixiloc.vtodo.data.model.Todo
import me.saket.swipe.SwipeAction
import me.saket.swipe.SwipeableActionsBox

@Composable
fun TodoItem(
    modifier: Modifier = Modifier,
    todo: Todo,
    changeChecked: (Todo) -> Unit,
    onClick: (todo: Todo) -> Unit,
    onDelete: (todo: Todo) -> Unit
) {
    val textStyle =
        if (todo.completed) MaterialTheme.typography.bodyMedium.copy(textDecoration = TextDecoration.LineThrough) else MaterialTheme.typography.bodyMedium

    val deleteAction = SwipeAction(
        icon = rememberVectorPainter(Icons.TwoTone.Delete),
        background = Color.Red,
        onSwipe = { onDelete(todo) }
    )

    val checkedAction = SwipeAction(
        icon = rememberVectorPainter(Icons.TwoTone.Done),
        background = Color.Yellow,
        onSwipe = { changeChecked(todo) }
    )
    SwipeableActionsBox(
        endActions = listOf(checkedAction, deleteAction),
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .background(color = Color.White, shape = MaterialTheme.shapes.small)
                .clip(shape = MaterialTheme.shapes.small)
                .clickable { onClick(todo) }
                .padding(vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(checked = todo.completed, onCheckedChange = { changeChecked(todo) })
            Spacer(modifier = Modifier.width(10.dp))
            Text(text = todo.name, style = textStyle)
        }
    }
}