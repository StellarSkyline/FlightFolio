package com.example.flightfolio.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun InputText(
    modifier: Modifier = Modifier,
    text: String = "",
    onChange: (String) -> Unit,
) {

    OutlinedTextField(
        modifier = modifier
            .fillMaxWidth()
            .height(50.dp),
        value = text,
        colors = OutlinedTextFieldDefaults.colors(unfocusedContainerColor = Color.White),
        onValueChange = {
            onChange(it)
        },
        textStyle = TextStyle(
            fontSize = 18.sp,
            color = Color.Black
        ),
    )
}

@Composable
@Preview
fun InputTextPreview() {
    InputText(text = "test") {
        it
    }

}