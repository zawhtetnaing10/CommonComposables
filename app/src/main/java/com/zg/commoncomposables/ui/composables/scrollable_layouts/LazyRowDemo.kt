package com.zg.commoncomposables.ui.composables.scrollable_layouts

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zg.commoncomposables.ui.theme.CommonComposablesTheme

@Composable
fun LazyRowDemo(modifier: Modifier = Modifier) {
    Box(contentAlignment = Alignment.Center, modifier = modifier.fillMaxSize()){
        LazyRow (modifier = modifier.height(32.dp)) {
            itemsIndexed((1..50).toList()){ index, item ->
                Row(modifier = Modifier.padding(start = 8.dp, end = 8.dp)){
                    Icon(Icons.Default.Star, contentDescription = null)
                    Spacer(Modifier.width(8.dp))
                    Text("Item Number. $item")
                }
                if(index < 49)
                    VerticalDivider()
            }
        }
    }
}

@Preview
@Composable
private fun LazyRowDemoPreview() {
    CommonComposablesTheme {
        LazyRowDemo()
    }
}