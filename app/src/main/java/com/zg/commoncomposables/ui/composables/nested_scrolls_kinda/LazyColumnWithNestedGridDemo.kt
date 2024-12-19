package com.zg.commoncomposables.ui.composables.nested_scrolls_kinda

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zg.commoncomposables.ui.theme.CommonComposablesTheme
import kotlin.math.ceil

@Composable
fun LazyColumnWithNestedGridDemo(modifier: Modifier = Modifier) {

    val firstListItems = remember { mutableStateListOf("Apple vision pro", "Android XR", "Meta Quest", "Valve Index") }
    val secondListItems = remember {
        mutableStateListOf(
            "Astrobot",
            "Black Myth: Wukong",
            "Elden Ring: Shadow of the Erdtree",
            "Balatro",
            "Final Fantasy VII Rebirth"
        )
    }

    LazyColumn(modifier = modifier) {
        // First List
        items(firstListItems, key = { it }) {
            Button(onClick = {}) {
                Text("First list item : $it")
            }
        }

        val gridHeight = (ceil(secondListItems.count().toDouble() / 2).toInt() * 56).dp
        // Second Grid
        item {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = modifier.height(gridHeight),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(secondListItems){
                    ElevatedButton(onClick = {}, Modifier.height(48.dp)) {
                        Text("Second list item : $it", maxLines = 1)
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun LazyColumnWithNestedGridDemoPreview() {
    CommonComposablesTheme {
        LazyColumnWithNestedGridDemo()
    }
}