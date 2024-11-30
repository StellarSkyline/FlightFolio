package com.example.flightfolio.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.flightfolio.ui.theme.FFColorList

@Composable
fun PrimaryButton(
    modifier: Modifier = Modifier,
    title: String = " ",
    onClick: () -> Unit
) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp),
        colors = ButtonDefaults.buttonColors(containerColor = FFColorList.btn_secondary),
        onClick = {
            onClick()
        }) {
        Text(
            text = title,
            fontSize = 16.sp,
            color = Color.White
        )
    }
}

@Composable
@Preview
fun PrimaryButtonPreview() {
    PrimaryButton(title = "Test") {
        //TODO: Implement Login Logic
    }
}