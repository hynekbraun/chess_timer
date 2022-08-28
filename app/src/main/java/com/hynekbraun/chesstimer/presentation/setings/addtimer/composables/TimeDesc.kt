package com.hynekbraun.chesstimer.presentation.setings.addtimer.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.hynekbraun.chesstimer.R

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
            textStyle = MaterialTheme.typography.h4,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            decorationBox = { innerTextField ->
                Box(
                    Modifier
                        .background(Color.LightGray, RoundedCornerShape(percent = 30))
                        .padding(16.dp)
                ) {
                    if (value.isEmpty()) {
                        Text(stringResource(R.string.time_placeholder_zero))
                    }
                    innerTextField()
                }
            },
        )
        Text(
            text = measurement,
            style = MaterialTheme.typography.body2
        )
    }
}
