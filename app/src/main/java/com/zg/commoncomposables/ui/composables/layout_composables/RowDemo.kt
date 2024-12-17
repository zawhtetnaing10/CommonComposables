package com.zg.commoncomposables.ui.composables.layout_composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
fun RowDemo(modifier: Modifier = Modifier) {
    Box(contentAlignment = Alignment.Center, modifier = modifier.fillMaxSize()) {
        Row(
            horizontalArrangement = Arrangement.End, // Test other arrangements
            verticalAlignment = Alignment.CenterVertically, // Test other vertical alignments
            modifier = Modifier.fillMaxWidth().fillMaxHeight()
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
private fun RowDemoPreview() {
    CommonComposablesTheme {
        RowDemo()
    }
}