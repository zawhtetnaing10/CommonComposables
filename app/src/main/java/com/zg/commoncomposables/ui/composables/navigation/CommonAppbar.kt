package com.zg.commoncomposables.ui.composables.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

// Common Appbar used in all screens.
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CommonAppbar(title: String, onTapBack: () -> Unit, showNavigationIcon: Boolean, modifier: Modifier = Modifier) {
    TopAppBar(
        title = {
            Text(title, color = Color.White)
        },
        navigationIcon = {
            if(showNavigationIcon){
                IconButton(
                    onClick = onTapBack
                ) {
                    Icon(Icons.AutoMirrored.Default.KeyboardArrowLeft, contentDescription = null, tint = Color.White)
                }
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),
        modifier = modifier
    )
}