package com.zg.commoncomposables

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.zg.commoncomposables.ui.composables.ButtonDemo
import com.zg.commoncomposables.ui.composables.CheckboxDemo
import com.zg.commoncomposables.ui.composables.ImageDemo
import com.zg.commoncomposables.ui.composables.RadioButtonDemo
import com.zg.commoncomposables.ui.composables.TextDemo
import com.zg.commoncomposables.ui.theme.CommonComposablesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CommonComposablesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CheckboxDemo(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}
