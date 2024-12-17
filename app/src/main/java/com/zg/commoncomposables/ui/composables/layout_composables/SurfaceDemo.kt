package com.zg.commoncomposables.ui.composables.layout_composables

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zg.commoncomposables.ui.theme.CommonComposablesTheme

@Composable
fun SurfaceDemo(modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.fillMaxSize()
    ) {
        // Surface can be used to create a custom button
        Surface(
            shape = RoundedCornerShape(16.dp),
            contentColor = Color.Red,
            color = Color.LightGray,
            modifier = modifier,
            border = BorderStroke(width = 1.dp, Color.Magenta),
            onClick = {
                Log.d("SurfaceTapped", "Surface composable clicked")
            }
        ) {
            //Image(painterResource(R.drawable.youtube_logo), contentDescription = null)

            Text("Content", modifier = Modifier.padding(24.dp))
        }
    }
}

@Preview(device = "spec:width=500px,height=400px,dpi=440,orientation=portrait", showBackground = true)
@Composable
private fun SurfaceDemoPreview() {
    CommonComposablesTheme {
        SurfaceDemo()
    }
}