package com.zg.commoncomposables.ui.composables.layout_composables

import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.zg.commoncomposables.ui.theme.CommonComposablesTheme

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun FlowLayoutDemo(modifier: Modifier = Modifier) {
    // Flow Row
//    FlowRow(modifier = modifier) {
//        (1..30).toList().forEach {
//           Button(onClick = {}) {
//               Text("Number $it")
//           }
//       }
//    }

    // Flow Column
    FlowColumn(modifier = modifier) {
        (1..30).toList().forEach {
            Button(onClick = {}){
                Text("Number $it")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun FlowLayoutDemoPreview() {
    CommonComposablesTheme {
        FlowLayoutDemo()
    }
}