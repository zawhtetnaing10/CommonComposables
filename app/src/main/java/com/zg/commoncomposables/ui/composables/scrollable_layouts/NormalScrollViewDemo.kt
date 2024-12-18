package com.zg.commoncomposables.ui.composables.scrollable_layouts

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zg.commoncomposables.ui.theme.CommonComposablesTheme

@Composable
fun NormalScrollViewDemo(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize().verticalScroll(rememberScrollState())) {
        Surface(color = Color.Red, modifier = Modifier.height(500.dp).fillMaxWidth()) {
            Box(contentAlignment = Alignment.Center){
                Text("Red Box", color = Color.White)
            }
        }
        Surface(color = Color.Green, modifier = Modifier.height(500.dp).fillMaxWidth()) {
            Box(contentAlignment = Alignment.Center){
                Text("Green Box", color = Color.White)
            }
        }
        Surface(color = Color.Magenta, modifier = Modifier.height(500.dp).fillMaxWidth()) {
            Box(contentAlignment = Alignment.Center){
                Text("Purple Box", color = Color.White)
            }
        }
        Surface(color = Color.Cyan, modifier = Modifier.height(500.dp).fillMaxWidth()) {
            Box(contentAlignment = Alignment.Center){
                Text("Cyan Box", color = Color.White)
            }
        }
    }
}

@Preview
@Composable
private fun NormalScrollViewDemoPreview() {
    CommonComposablesTheme {
        NormalScrollViewDemo()
    }
}