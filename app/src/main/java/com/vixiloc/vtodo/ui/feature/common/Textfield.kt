package com.vixiloc.vtodo.ui.feature.common

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vixiloc.vtodo.ui.theme.VTodoTheme

@Composable
fun VTextField(
    modifier: Modifier = Modifier,
    label: String,
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    maxLines: Int = 1,
    singleLine: Boolean = true
) {
    BasicTextField(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        textStyle = MaterialTheme.typography.bodyMedium,
        maxLines = maxLines,
        singleLine = singleLine,
        decorationBox = { innerTextField ->
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(text = label, style = MaterialTheme.typography.bodySmall)
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color.White, shape = MaterialTheme.shapes.small)
                        .padding(vertical = 20.dp, horizontal = 10.dp)
                ) {
                    innerTextField()
                }
            }
        }
    )
}

@Composable
fun VTfSearch(
    modifier: Modifier = Modifier,
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    maxLines: Int = 1,
    singleLine: Boolean = true
) {
    BasicTextField(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        textStyle = MaterialTheme.typography.bodyMedium,
        maxLines = maxLines,
        singleLine = singleLine,
        decorationBox = { innerTextField ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.White, shape = MaterialTheme.shapes.small),
                verticalAlignment = Alignment.CenterVertically
            ) {
                val screenWidth = LocalConfiguration.current.screenWidthDp.dp
                val iconWidth = screenWidth / 5f
                val textWidth = screenWidth / 1.2f
                Box(
                    modifier = Modifier
                        .width(textWidth)
                        .padding(vertical = 20.dp, horizontal = 10.dp)
                ) {
                    innerTextField()
                }
                Icon(
                    imageVector = Icons.Outlined.Search,
                    contentDescription = null,
                    modifier = Modifier.width(iconWidth)
                )
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun VTextFieldPreview() {
    var value by remember {
        mutableStateOf(TextFieldValue("KAdjshaksdhKAdjshaksdhKAdjshaksdhKAdjshaksdhKAdjshaksdhKAdjshaksdh"))
    }
    VTodoTheme {
        Surface(color = Color(0xFFF4F4F4)) {
            VTfSearch(
                value = value,
                onValueChange = { value = it },
                modifier = Modifier.padding(10.dp)
            )
        }
    }
}