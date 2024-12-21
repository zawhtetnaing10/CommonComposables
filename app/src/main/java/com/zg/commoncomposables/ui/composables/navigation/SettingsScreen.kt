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
fun SettingsScreen(message: String, onTapBack: () -> Unit, onTapBackToHome: () -> Unit, modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            CommonAppbar(
                title = "Setting Screen",
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
                Button(onClick = onTapBackToHome) {
                    Text("Back to Home")
                }
            }
        }
    }
}

@Preview
@Composable
private fun SettingsScreenPreview() {
    CommonComposablesTheme {
        SettingsScreen("Message", onTapBack = {}, onTapBackToHome = {})
    }
}