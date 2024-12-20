package com.zg.commoncomposables.ui.composables.navigation_drawer

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zg.commoncomposables.ui.theme.CommonComposablesTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationDrawerDemo(modifier: Modifier = Modifier) {

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = { ModalNavigationDrawerContent() },
        gesturesEnabled = true,
        modifier = modifier
    ) {
        Scaffold(topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.Red
                ),
                title = {
                    Text("Navigation Drawer", color = Color.White)
                },
                navigationIcon = {
                    IconButton(onClick = {
                        scope.launch {
                            if (drawerState.isOpen)
                                drawerState.close()
                            else
                                drawerState.open()
                        }
                    }) {
                        Icon(Icons.Default.Menu, contentDescription = null, tint = Color.White)
                    }
                }
            )
        }, modifier = modifier) { paddingValues ->
            Box(
                contentAlignment = Alignment.Center, modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
            ) {
                Text("Navigation Drawer")
            }
        }
    }

}

@Composable
fun ModalNavigationDrawerContent(modifier: Modifier = Modifier) {

    val navigationItems = listOf("Go to Videos", "Go to Settings", "Go to Trending")

    Surface(color = Color.White, modifier = modifier
        .width(265.dp)
        .fillMaxHeight()) {
        Column {
            // Top Section
            Surface(color = Color.Red, modifier = modifier
                .height(250.dp)
                .fillMaxWidth()) {
                Box(contentAlignment = Alignment.Center) {
                    Text("Top Section", color = Color.White)
                }
            }

            Spacer(Modifier.height(16.dp))

            // List
            navigationItems.forEach {
                Row(modifier = Modifier.padding(top = 8.dp)) {
                    Icon(Icons.Default.PlayArrow, contentDescription = null)
                    Spacer(Modifier.width(20.dp))
                    Text(it)
                }
            }
        }
    }
}

@Preview
@Composable
private fun NavigationDrawerDemoPreview() {
    CommonComposablesTheme {
        NavigationDrawerDemo()
    }
}