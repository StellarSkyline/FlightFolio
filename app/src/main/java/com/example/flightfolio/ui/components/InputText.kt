package com.example.flightfolio.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
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
fun PasswordInputText(
    modifier: Modifier = Modifier,
    text: String = "",
    onChange: (String) -> Unit,
) {
    var passwordVisible = remember { mutableStateOf(false) }

    OutlinedTextField(
        modifier = modifier
            .fillMaxWidth()
            .height(50.dp),
        value = text,
        visualTransformation = if (passwordVisible.value) VisualTransformation.None
        else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            val image = if (passwordVisible.value)
                Icons.Filled.Visibility
            else Icons.Filled.VisibilityOff

            IconButton(onClick = { passwordVisible.value = !passwordVisible.value }) {
                Icon(imageVector = image, "description")
            }
        },
        colors = OutlinedTextFieldDefaults.colors(unfocusedContainerColor = Color.White),
        onValueChange = { onChange(it) },
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

@Composable
@Preview
fun PasswordInputTextPreview() {
    PasswordInputText(text = "test") {
        it
    }
}