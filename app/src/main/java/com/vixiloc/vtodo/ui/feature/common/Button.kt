package com.vixiloc.vtodo.ui.feature.common

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vixiloc.vtodo.ui.theme.VTodoTheme

@Composable
fun VButton(modifier: Modifier = Modifier, label: String, onClick: () -> Unit) {
    Box(
        modifier = modifier
            .background(
                color = MaterialTheme.colorScheme.primary,
                shape = MaterialTheme.shapes.small
            )
            .clip(shape = MaterialTheme.shapes.small)
            .clickable { onClick() }
            .padding(15.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodySmall,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun VButtonPreview() {
    VTodoTheme {
        Surface(color = Color(0xFFF4F4F4), modifier = Modifier.padding(14.dp)) {
            VButton(label = "Button", modifier = Modifier.fillMaxWidth(), onClick = {})
        }
    }
}