package com.vixiloc.vtodo.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.materialkolor.rememberDynamicColorScheme

@Composable
fun VTodoTheme(
    darkTheme: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = rememberDynamicColorScheme(Color(0xFF0094FF), darkTheme)

    MaterialTheme(
        colorScheme = colorScheme.copy(surface = Color(0xFFF4F4F4)),
        typography = Typography,
        content = content
    )
}