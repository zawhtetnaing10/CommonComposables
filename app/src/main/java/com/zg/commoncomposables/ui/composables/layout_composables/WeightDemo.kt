package com.zg.commoncomposables.ui.composables.layout_composables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.zg.commoncomposables.ui.theme.CommonComposablesTheme

@Composable
fun WeightDemo(modifier: Modifier = Modifier) {
    Box(contentAlignment = Alignment.Center, modifier = modifier.fillMaxSize()) {
        // Play around with weight values of the buttons.
        // If only one button has weight value, it'll take the available space and other buttons will be wrap-content
        Row {
            Button(
                colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
                onClick = {},
                modifier = Modifier.weight(1.2f)
            ) {
                Text("Red", color = Color.Black)
            }

            Button(
                colors = ButtonDefaults.buttonColors(containerColor = Color.Blue),
                onClick = {},
                modifier = Modifier.weight(2.8f)
            ) {
                Text("Blue", color = Color.Black)
            }

            Button(
                colors = ButtonDefaults.buttonColors(containerColor = Color.Yellow),
                onClick = {}, modifier = Modifier.weight(2.0f),
            ) {
                Text("Yellow", color = Color.Black)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WeightDemoPreview() {
    CommonComposablesTheme {
        WeightDemo()
    }
}