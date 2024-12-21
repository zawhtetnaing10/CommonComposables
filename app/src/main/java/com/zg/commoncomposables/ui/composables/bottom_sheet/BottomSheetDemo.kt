package com.zg.commoncomposables.ui.composables.bottom_sheet

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zg.commoncomposables.ui.theme.CommonComposablesTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetDemo(modifier: Modifier = Modifier) {
    val bottomSheetState = rememberModalBottomSheetState()
    var showBottomSheet by remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        floatingActionButton = {
            IconButton(onClick = {
                showBottomSheet = true // Will it show bottom sheet with animation?
            }, colors = IconButtonDefaults.iconButtonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = Color.White
            )) {
                Icon(Icons.Default.Add, contentDescription = null)
            }
        },
        modifier = modifier
    ) { paddingValues ->
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            Text("BottomSheet demo")
        }

        if (showBottomSheet)
            ModalBottomSheet(
                onDismissRequest = { showBottomSheet = false },
                sheetState = bottomSheetState,
                containerColor = Color.Magenta
            ) {
                Surface(Modifier.height(400.dp), color = Color.Transparent) {
                    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()){
                        Column {
                            Text("This is the bottom sheet.", color = Color.White)

                            Button(onClick = {
                                // Hide the bottom sheet asynchronously and then
                                coroutineScope.launch {
                                   bottomSheetState.hide()
                                }.invokeOnCompletion {
                                    // After hiding the bottom sheet, remove it from the composable hierarchy.
                                    if(!bottomSheetState.isVisible){
                                        showBottomSheet = false
                                    }
                                }
                            }) {
                                Text("Close Bottom Sheet")
                            }
                        }
                    }
                }
            }
    }
}

@Preview
@Composable
private fun BottomSheetDemoPreview() {
    CommonComposablesTheme {
        BottomSheetDemo()
    }
}