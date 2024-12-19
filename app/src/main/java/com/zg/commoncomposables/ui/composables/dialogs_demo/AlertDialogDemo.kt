package com.zg.commoncomposables.ui.composables.dialogs_demo

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.DialogProperties
import com.zg.commoncomposables.ui.theme.CommonComposablesTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlertDialogDemo(modifier: Modifier = Modifier) {

    var showAlertDialog by remember { mutableStateOf(false) }

    val configuration = LocalConfiguration.current
    val dialogWidth = configuration.screenWidthDp.dp - 48.dp
    val dialogHeight = (configuration.screenHeightDp * 0.8).dp

    Box(contentAlignment = Alignment.Center, modifier = modifier.fillMaxSize()) {
        Button(onClick = {
            showAlertDialog = true
        }) {
            Text("Show Dialog")
        }
    }

    if (showAlertDialog)
        BasicAlertDialog(
            onDismissRequest = { showAlertDialog = false },
            properties = DialogProperties(dismissOnClickOutside = false, dismissOnBackPress = false, usePlatformDefaultWidth = false),
            modifier = Modifier.width(dialogWidth).height(dialogHeight) /// Custom Width and Height for dialog
        ) {
            Surface(color = Color.White, shape = RoundedCornerShape(4.dp), shadowElevation = 2.dp) {
                Column(Modifier.padding(16.dp)) {
                    Text("Hello", fontSize = 32.sp, fontWeight = FontWeight.Bold)

                    Spacer(Modifier.height(24.dp))

                    Text("Your subscription has expired.")

                    // Will take up the available space.
                    Spacer(Modifier.weight(1f))

                    Row(Modifier.align(Alignment.End)) {
                        Button(onClick = { showAlertDialog = false }) {
                            Text("OK")
                        }
                        Spacer(Modifier.width(16.dp))
                        OutlinedButton(onClick = { showAlertDialog = false }) {
                            Text("CANCEL")
                        }
                    }
                }
            }
        }

}

@Preview(showBackground = true)
@Composable
private fun AlertDialogDemoPreview() {
    CommonComposablesTheme {
        AlertDialogDemo()
    }
}