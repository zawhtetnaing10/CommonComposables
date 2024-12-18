package com.zg.commoncomposables.ui.composables.scrollable_layouts

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zg.commoncomposables.ui.theme.CommonComposablesTheme

@Composable
fun LazyColumnDemo(modifier: Modifier = Modifier) {

    // Lazy Column
    LazyColumn(modifier = modifier) {
        itemsIndexed((1..50).toList()){ index, item ->
            Row(modifier = Modifier.padding(bottom = 8.dp, top = 8.dp)){
                Icon(Icons.Default.Star, contentDescription = null)
                Spacer(Modifier.width(8.dp))
                Text("Item Number. $item")
            }
            if(index < 49)
                HorizontalDivider()
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun LazyColumnDemoPreview() {
    CommonComposablesTheme {
        LazyColumnDemo()
    }
}