package com.zg.commoncomposables.ui.composables.scrollable_layouts

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zg.commoncomposables.R
import com.zg.commoncomposables.ui.theme.CommonComposablesTheme

@Composable
fun GridDemo(modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp),
        modifier = modifier
    ) {
        items((1..33).toList()) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Surface(
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier.height(150.dp).fillMaxWidth()
                ) {
                    Image(
                        painterResource(R.drawable.youtube_logo),
                        contentDescription = null,
                        contentScale = ContentScale.FillBounds,
                    )
                }
                Spacer(Modifier.height(8.dp))
                Text("Youtube")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun GridDemoPreview() {
    CommonComposablesTheme {
        GridDemo()
    }
}