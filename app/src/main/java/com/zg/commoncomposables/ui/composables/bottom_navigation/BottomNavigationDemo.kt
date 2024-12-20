package com.zg.commoncomposables.ui.composables.bottom_navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.zg.commoncomposables.ui.theme.CommonComposablesTheme

@Composable
fun BottomNavigationDemo(modifier: Modifier = Modifier) {
    Scaffold(bottomBar = { BottomNavigationBar() }, modifier = modifier) { paddingValue ->
        Box(
            contentAlignment = Alignment.Center, modifier = Modifier
                .padding(
                    top = paddingValue.calculateTopPadding(),
                    start = paddingValue.calculateStartPadding(LayoutDirection.Ltr),
                    end = paddingValue.calculateEndPadding(LayoutDirection.Ltr),
                    bottom = 0.dp
                )
                .fillMaxSize()
        ) {
            Text("Bottom Navigation")
        }
    }
}

@Composable
fun BottomNavigationBar(modifier: Modifier = Modifier) {
    val bottomNavigationItems = listOf(
        BottomNavigationItemData(title = "Home", icon = Icons.Default.Home),
        BottomNavigationItemData(title = "Profile", icon = Icons.Default.AccountCircle)
    )
    var selectedValue by remember { mutableStateOf("Home") }

    NavigationBar(containerColor = Color.LightGray, modifier = modifier) {
        bottomNavigationItems.forEach {
            NavigationBarItem(
                selected = selectedValue == it.title,
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.Red,
                    selectedTextColor = Color.White,
                    indicatorColor = Color.Transparent
                ),
                onClick = {
                    selectedValue = it.title
                },
                icon = { Icon(it.icon, contentDescription = null) },
                label = { Text(it.title) }
            )
        }
    }
}

data class BottomNavigationItemData(val title: String, val icon: ImageVector)

@Preview
@Composable
private fun BottomNavigationDemoPreview() {
    CommonComposablesTheme {
        BottomNavigationDemo()
    }
}