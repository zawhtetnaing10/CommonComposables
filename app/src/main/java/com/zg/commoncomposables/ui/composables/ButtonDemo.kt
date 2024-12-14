package com.zg.commoncomposables.ui.composables

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zg.commoncomposables.ui.theme.CommonComposablesTheme

@Composable
fun ButtonDemo(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        // Normal Button
        Button(
            onClick = {
                Log.d("BTN", "Button Tapped")
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.LightGray,
                contentColor = Color.Yellow,
                disabledContainerColor = Color.Gray,
                disabledContentColor = Color.DarkGray
            ),
            enabled = true,
            border = BorderStroke(width = 1.dp, color = Color.Blue),
            shape = RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp),
        ) {
            Text("Button")
        }

        // Outlined Button
        OutlinedButton(
            onClick = {
                Log.d("OutlineBTN", "Button Tapped")
            },
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = Color.Red,
                containerColor = Color.Black
            ),
            border = BorderStroke(width = 1.dp, color = Color.Yellow),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text("Outlined Button")
        }

        // Elevated Button
        ElevatedButton(
            onClick = {
                Log.d("ElevBTN", "Button Tapped")
            },
            colors = ButtonDefaults.elevatedButtonColors(
                contentColor = Color.Black,
                containerColor = Color.Green
            ),
            elevation = ButtonDefaults.buttonElevation(4.dp),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text("Elevated Button")
        }
    }
}

@Preview
@Composable
private fun ButtonDemoPreview() {
    CommonComposablesTheme {
        ButtonDemo()
    }
}