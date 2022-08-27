package com.hynekbraun.chesstimer.presentation.setings.addtimer.composables

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TimeDesc(
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit,
    value: String,
    measurement: String
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        BasicTextField(
            modifier = Modifier.width(IntrinsicSize.Min),
            value = value,
            onValueChange = { onValueChange(it) },
        textStyle = MaterialTheme.typography.h4)
        Text(
            text = measurement,
            style = MaterialTheme.typography.body2
        )
    }
}
