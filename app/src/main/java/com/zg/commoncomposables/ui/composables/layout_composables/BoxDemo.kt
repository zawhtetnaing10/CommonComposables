package com.zg.commoncomposables.ui.composables.layout_composables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zg.commoncomposables.ui.theme.CommonComposablesTheme

@Composable
fun BoxDemo(modifier: Modifier = Modifier) {

    // With default alignments (Similar to Stack + Align widget)
//    Box(modifier = modifier.fillMaxSize()){
//        Text("Top Left Text", modifier = Modifier.align(Alignment.TopStart))
//
//        Text("Top Right Text", modifier = Modifier.align(Alignment.TopEnd))
//
//        Text("Center Text", modifier = Modifier.align(Alignment.Center))
//
//        Text("Bottom Left Text", modifier = Modifier.align(Alignment.BottomStart))
//
//        Text("Bottom Right Text", modifier = Modifier.align(Alignment.BottomEnd))
//    }

    // With precise positioning (Similar to Stack + Positioed widget)
    Box(modifier = modifier.fillMaxSize()) {
        Text("Top Left Text", modifier = Modifier.offset(x = 16.dp, y = 16.dp))

        Text("Top Right Text", modifier = Modifier
            .align(Alignment.TopEnd)
            .offset(x = (-16).dp, y = 45.dp))

        Text("Center Text", modifier = Modifier.align(Alignment.Center))

        Text("Bottom Left Text", modifier = Modifier
            .align(Alignment.BottomStart)
            .offset(x = 16.dp, y = (-88).dp))

        Text("Bottom Right Text", modifier = Modifier
            .align(Alignment.BottomEnd)
            .offset(x = (-55).dp, y = (-32).dp))
    }
}

@Preview(showBackground = true)
@Composable
private fun BoxDemoPreview() {
    CommonComposablesTheme {
        BoxDemo()
    }
}