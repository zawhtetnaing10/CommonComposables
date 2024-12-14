package com.zg.commoncomposables.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.compose.LocalPlatformContext
import coil3.compose.SubcomposeAsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.zg.commoncomposables.R
import com.zg.commoncomposables.ui.theme.CommonComposablesTheme

@Composable
fun ImageDemo(modifier: Modifier = Modifier) {

    Column(modifier = modifier) {
        // Simple Image
        Image(
            painter = painterResource(R.drawable.youtube_logo),
            contentDescription = "Youtube logo image",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.size(width = 200.dp, height = 150.dp)
        )

        // Network Image with loading and error as images
        AsyncImage(
            model = "https://picsum.photos/536/354",
            contentDescription = "Network image",
            contentScale = ContentScale.Crop,
            placeholder = painterResource(R.drawable.loading_skeleton),
            error = painterResource(R.drawable.image_loading_error),
            modifier = Modifier.size(width = 250.dp, height = 200.dp)
        )

        // Network Image with loading and error as composables
        SubcomposeAsyncImage(
            model = ImageRequest.Builder(LocalPlatformContext.current)
                .data("https://picsum.photos/id/237/200/300")
                .crossfade(true)
                .build(),
            contentDescription = "Async image with loading placeholder",
            contentScale = ContentScale.Crop,
            loading = {
                Box(contentAlignment = Alignment.Center, modifier = Modifier.matchParentSize()) {
                    CircularProgressIndicator()
                }
            },
            error = {
                Box(contentAlignment = Alignment.Center, modifier = Modifier.matchParentSize()) {
                    Text("Cannot load image", color = Color.Red)
                }
            },
            modifier = Modifier.size(width = 300.dp, height = 200.dp)
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