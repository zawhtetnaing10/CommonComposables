package com.zg.commoncomposables

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.zg.commoncomposables.ui.composables.display_composables.DropdownDemo
import com.zg.commoncomposables.ui.composables.layout_composables.RowDemo
import com.zg.commoncomposables.ui.composables.layout_composables.SurfaceDemo
import com.zg.commoncomposables.ui.theme.CommonComposablesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CommonComposablesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    RowDemo(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}
