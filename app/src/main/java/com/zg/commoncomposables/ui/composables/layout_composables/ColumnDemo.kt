package com.zg.commoncomposables.ui.composables.layout_composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
fun ColumnDemo(modifier: Modifier = Modifier) {
    Box(contentAlignment = Alignment.Center, modifier = modifier.fillMaxSize()) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween, // Test other arrangements
            horizontalAlignment = Alignment.CenterHorizontally, // Test other horizontal alignments
            modifier = Modifier.fillMaxSize()
        ) {
            Button(colors = ButtonDefaults.buttonColors(containerColor = Color.Red), onClick = {

            }) {
                Text("Red", color = Color.Black)
            }

            Button(colors = ButtonDefaults.buttonColors(containerColor = Color.Blue), onClick = {

            }) {
                Text("Blue", color = Color.Black)
            }

            Button(colors = ButtonDefaults.buttonColors(containerColor = Color.Yellow), onClick = {

            }) {
                Text("Yellow", color = Color.Black)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ColumnDemoPreview() {
    CommonComposablesTheme {
        ColumnDemo()
    }
}