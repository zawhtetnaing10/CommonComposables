package com.zg.commoncomposables

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.zg.commoncomposables.ui.composables.navigation.NavigationDemo
import com.zg.commoncomposables.ui.theme.CommonComposablesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CommonComposablesTheme {
                NavigationDemo()
            }
        }
    }
}
