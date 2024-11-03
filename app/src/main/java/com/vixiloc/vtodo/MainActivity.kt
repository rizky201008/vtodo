package com.vixiloc.vtodo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Surface
import cafe.adriel.voyager.navigator.Navigator
import com.vixiloc.vtodo.ui.feature.home.composables.HomeScreen
import com.vixiloc.vtodo.ui.theme.VTodoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VTodoTheme {
                Surface {
                    Navigator(HomeScreen())
                }
            }
        }
    }
}