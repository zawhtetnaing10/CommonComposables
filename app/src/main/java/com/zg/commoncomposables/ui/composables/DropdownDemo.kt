package com.zg.commoncomposables.ui.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
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
fun DropdownDemo(modifier: Modifier = Modifier) {

    // Dropdown items
    val mobileFrameworks = listOf("Android Native", "iOS Native", "Flutter", "Cordova")

    // Selected item
    var selectedValue : String? by remember { mutableStateOf(null) }

    // Flag to determine if drop down is expanded or not
    var isExpanded by remember { mutableStateOf(false) }
    Box(contentAlignment = Alignment.Center, modifier = modifier.fillMaxSize()){

        // Dropdown trigger and DropDownMenu themselves should be inside a box
        Surface(color = Color.LightGray, shape = RoundedCornerShape(8.dp)) {
            Box {
                // Dropdown button UI
                Row(
                    modifier = Modifier
                        .width(200.dp)
                        .padding(start = 16.dp)
                        .clickable { isExpanded = !isExpanded },
                    horizontalArrangement = Arrangement.Absolute.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(selectedValue ?: "Mobile Framework")
                    IconButton(onClick = {
                        isExpanded = !isExpanded
                    }) {
                        Icon(Icons.Default.ArrowDropDown, contentDescription = "Open drop down")
                    }
                }

                // Dropdown Menu
                DropdownMenu(expanded = isExpanded, onDismissRequest = { isExpanded = false }) {
                    mobileFrameworks.forEachIndexed { index, item ->
                        Column{
                            DropdownMenuItem(text = {
                                Text(item)
                            }, onClick = {
                                selectedValue = item
                                isExpanded = false
                            })
                            // Divider
                            if(index < mobileFrameworks.count() - 1)
                                HorizontalDivider()
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DropdownDemoPreview() {
    CommonComposablesTheme {
        DropdownDemo()
    }
}