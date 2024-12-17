package com.zg.commoncomposables.ui.composables.display_composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zg.commoncomposables.ui.theme.CommonComposablesTheme

@Composable
fun TextDemo(modifier: Modifier = Modifier) {
    // Building Annotated Text
    val annotatedText = buildAnnotatedString {
        withStyle(style = SpanStyle(color = Color.Magenta, fontSize = 24.sp)){
            append("First Text")
        }

        withStyle(style = SpanStyle(color = Color.Green, fontSize = 32.sp, fontWeight = FontWeight.Bold)){
            append("Second Text")
        }

        withStyle(style = SpanStyle(color = Color.DarkGray, fontSize = 12.sp, fontWeight = FontWeight.Bold)){
            append("Third Text")
        }
    }

    Column(modifier = modifier) {
        // Normal Text
        Text(
            "This is a very long text. This is a very long text. This is a very long text. This is a very long text. This is a very long text. ",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Red,
            overflow = TextOverflow.Ellipsis,
            maxLines = 2,
            letterSpacing = 2.sp,
            lineHeight = 56.sp,
            //textDecoration = TextDecoration.Underline
            textDecoration = TextDecoration.LineThrough,
            modifier = Modifier.background(color = Color.Cyan).padding(8.dp)
        )

        // Annotated Text
        Text(annotatedText)
    }
}

@Preview(backgroundColor = 0xFFFFFFFF, showBackground = true)
@Composable
private fun TextDemoPreview() {
    CommonComposablesTheme {
        TextDemo()
    }
}