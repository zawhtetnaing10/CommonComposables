package com.zg.commoncomposables.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zg.commoncomposables.R
import com.zg.commoncomposables.ui.theme.CommonComposablesTheme

@Composable
fun ImageDemo(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Image(
            painter = painterResource(R.drawable.youtube_logo),
            contentDescription = "Youtube logo image",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.size(width = 200.dp, height = 150.dp)
        )
    }
}

@Preview
@Composable
private fun ImageDemoPreview() {
    CommonComposablesTheme {
        ImageDemo()
    }
}