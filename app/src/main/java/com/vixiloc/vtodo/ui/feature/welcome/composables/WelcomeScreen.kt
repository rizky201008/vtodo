package com.vixiloc.vtodo.ui.feature.welcome.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import cafe.adriel.voyager.core.screen.Screen
import com.vixiloc.vtodo.R
import com.vixiloc.vtodo.ui.theme.VTodoTheme

class WelcomeScreen : Screen {
    @Composable
    override fun Content() {
        Welcome()
    }

}

@Composable
fun Welcome(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo_transparent),
            contentDescription = null
        )
    }
}

@Preview
@Composable
private fun WelcomeScreenPreview() {
    VTodoTheme(darkTheme = false) {
        Surface {
            Welcome()
        }
    }
}