package com.zg.commoncomposables.ui.composables

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zg.commoncomposables.ui.theme.CommonComposablesTheme

@Composable
fun IconDemo(modifier: Modifier = Modifier) {
    Column {
        // Icon
        Icon(
            Icons.Default.Call, contentDescription = "Call Icon",
            tint = Color.Cyan,
            modifier = Modifier.size(48.dp)
        )

        // Icon Button. Automatically rendered as a circle
        IconButton(onClick ={
            Log.d("CloseBTN", "Close button tapped")
        }, colors = IconButtonDefaults.iconButtonColors(
            containerColor = Color.LightGray,
        )) {
            Icon(Icons.Default.Close, contentDescription = "Close Button", tint = Color.Magenta)
        }
    }
}

@Preview
@Composable
private fun IconDemoPreview() {
    CommonComposablesTheme {
        IconDemo()
    }
}