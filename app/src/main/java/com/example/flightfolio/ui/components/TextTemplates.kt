package com.example.flightfolio.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposableTarget
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.flightfolio.ui.theme.FFColorList


@Composable
fun TitleText(modifier:Modifier = Modifier, text:String = "") {
    Text(
        modifier = modifier,
        text = text,
        fontSize = 48.sp,
        color = FFColorList.txt_primary
    )
}

@Composable
fun LabelText(modifier:Modifier = Modifier, text:String = "") {
    Text(
        modifier = modifier,
        text = text,
        color = FFColorList.txt_primary,
        fontSize = 16.sp
    )

}

@Composable
@Preview
fun TitleTextPreview() {
    TitleText(text = "test")
}

@Composable
@Preview
fun LabelTextPreview() {
    LabelText(text = "test")
}