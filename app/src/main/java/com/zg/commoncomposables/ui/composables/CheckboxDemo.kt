package com.zg.commoncomposables.ui.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zg.commoncomposables.ui.theme.CommonComposablesTheme

@Composable
fun CheckboxDemo(modifier: Modifier = Modifier) {
    val iDEs: List<String> = listOf("Android Studio", "VSCode", "Eclipse", "PyCharm")
    val selectedIDEs = remember { mutableStateListOf<String>() }

    Column(modifier = modifier) {
        iDEs.forEach { ide ->
            Row(horizontalArrangement = Arrangement.spacedBy(4.dp), verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = selectedIDEs.contains(ide),
                    onCheckedChange = {
                        setCheckChange(selectedIDEs, ide)
                    },
                    /// Cannot have transparent background behind checkmark during checked state
                    colors = CheckboxDefaults.colors(
                        checkedColor = Color.DarkGray,
                        uncheckedColor = Color.DarkGray,
                        checkmarkColor = Color.Red
                    )
                )
                Text(ide, modifier = Modifier.clickable {
                    setCheckChange(selectedIDEs, ide)
                })
            }
        }
    }
}

private fun setCheckChange(selectedIDEs: SnapshotStateList<String>, ide: String) {
    if (selectedIDEs.contains(ide))
        selectedIDEs.remove(ide)
    else
        selectedIDEs.add(ide)
}


@Preview(showBackground = true)
@Composable
private fun CheckboxDemoPreview() {
    CommonComposablesTheme {
        CheckboxDemo()
    }
}