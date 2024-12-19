package com.zg.commoncomposables.ui.composables.nested_scrolls_kinda

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zg.commoncomposables.ui.theme.CommonComposablesTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LazyColumnWithSectionsDemo(modifier: Modifier = Modifier) {

    val firstList = listOf("Android", "iOS", "Flutter", "Xamarin", "Reactive Native")
    val secondList = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    LazyColumn(modifier = modifier) {
        stickyHeader {
            Surface(color = Color.Red, modifier = Modifier
                .height(250.dp)
                .fillMaxWidth()) {
                Box(contentAlignment = Alignment.Center) {
                    Text("First Section")
                }
            }
        }

        items(firstList) {
            Text("First List Item : $it")
        }

        item {
            Surface(color = Color.Cyan, modifier = Modifier
                .height(500.dp)
                .fillMaxWidth()) {
                Box(contentAlignment = Alignment.Center) {
                    Text("Second Section")
                }
            }
        }

        items(secondList) {
            Text("Second List Item : $it")
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun LazyColumnWithSectionsDemoPreview() {
    CommonComposablesTheme {
        LazyColumnWithSectionsDemo()
    }
}