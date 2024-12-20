package com.zg.commoncomposables.ui.composables.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.zg.commoncomposables.ui.theme.CommonComposablesTheme

@Composable
fun DetailsScreen(
    message: String,
    onTapBack: () -> Unit,
    onNavigateToSettings: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            CommonAppbar(
                title = "Details Screen",
                onTapBack = onTapBack,
                showNavigationIcon = true
            )
        }, modifier = modifier
    ) { paddingValues ->
        Box(
            contentAlignment = Alignment.Center, modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            Column {
                Text(message)
                Button(onClick = {
                    onNavigateToSettings("Hey, this is from details")
                }) {
                    Text("Navigate to settings screen")
                }
            }
        }
    }
}

@Preview
@Composable
private fun DetailsScreenDemo() {
    CommonComposablesTheme {
        DetailsScreen("Message from first screen", onTapBack = {}, onNavigateToSettings = {})
    }
}