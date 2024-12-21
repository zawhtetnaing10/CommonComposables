package com.zg.commoncomposables.ui.composables.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.zg.commoncomposables.ui.theme.CommonComposablesTheme

@Composable
fun DetailsScreen(message: String, onTapBack: () -> Unit, modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            DetailsAppbar(
                onTapBack = onTapBack
            )
        }, modifier = modifier
    ) { paddingValues ->
        Box(
            contentAlignment = Alignment.Center, modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            Text(message)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsAppbar(modifier: Modifier = Modifier, onTapBack: () -> Unit) {
    TopAppBar(
        title = {
            Text("Details Screen", color = Color.White)
        },
        navigationIcon = {
            IconButton(
                onClick = onTapBack
            ) {
                Icon(Icons.AutoMirrored.Default.KeyboardArrowLeft, contentDescription = null)
            }
        },
        modifier = modifier
    )
}

@Preview
@Composable
private fun DetailsScreenDemo() {
    CommonComposablesTheme {
        DetailsScreen("Message from first screen", onTapBack = {})
    }
}