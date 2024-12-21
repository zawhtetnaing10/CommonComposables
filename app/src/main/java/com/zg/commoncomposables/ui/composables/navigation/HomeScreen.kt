package com.zg.commoncomposables.ui.composables.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zg.commoncomposables.ui.theme.CommonComposablesTheme

@Composable
fun HomeScreen(modifier: Modifier = Modifier, onClickDetails : (String) -> Unit) {
    Box(contentAlignment = Alignment.Center, modifier = modifier.fillMaxSize()){
        Column {
            Text("This is home screen.")
            Spacer(Modifier.height(16.dp))
            Button(onClick = {
                onClickDetails("Message to second screen.")
            }) {
                Text("Navigate to details screen.")
            }
        }
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    CommonComposablesTheme {
        HomeScreen(onClickDetails = {})
    }
}