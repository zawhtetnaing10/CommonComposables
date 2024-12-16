package com.zg.commoncomposables.ui.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zg.commoncomposables.ui.theme.CommonComposablesTheme

@Composable
fun RadioButtonDemo(modifier: Modifier = Modifier) {
    val programmingLanguages = listOf("C++", "C", "Python", "Java", "Kotlin")
    var selectedOption by remember { mutableStateOf("") }

    Column(modifier = modifier) {
        programmingLanguages.forEach {
            Row(horizontalArrangement = Arrangement.spacedBy(4.dp), verticalAlignment = Alignment.CenterVertically){
                RadioButton(
                    selected = selectedOption == it,
                    onClick = {
                        selectedOption = it
                    },
                    // Currently cannot have different colors for the stroke and the selection.
                    colors = RadioButtonDefaults.colors(
                        selectedColor = Color.DarkGray,
                        unselectedColor = Color.DarkGray
                    )
                )
                Text(it, modifier = Modifier.clickable { selectedOption = it })
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun RadioButtonDemoPreview() {
    CommonComposablesTheme {
        RadioButtonDemo()
    }
}