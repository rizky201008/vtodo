package com.vixiloc.vtodo.ui.theme

import android.app.Activity
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import com.materialkolor.rememberDynamicColorScheme

@Composable
fun VTodoTheme(
    darkTheme: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = rememberDynamicColorScheme(Color(0xFF0094FF), darkTheme)
    val view = LocalView.current
    if (!view.isInEditMode) {
        /* getting the current window by tapping into the Activity */
        val currentWindow = (view.context as? Activity)?.window
            ?: throw Exception("Not in an activity - unable to get Window reference")

        SideEffect {
            currentWindow.statusBarColor = Color.Black.copy(alpha = 0.3f).toArgb()
            WindowCompat.getInsetsController(currentWindow, view).isAppearanceLightStatusBars =
                darkTheme
        }
    }


    MaterialTheme(
        colorScheme = colorScheme.copy(surface = Color(0xFFB7B7B7)),
        typography = Typography,
        content = content
    )
}