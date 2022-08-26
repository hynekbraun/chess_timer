package com.hynekbraun.chesstimer.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hynekbraun.chesstimer.R

//Disable ripple effect later

@Composable
fun TapField(
    modifier: Modifier = Modifier,
    time: String = stringResource(R.string.time_zero),
    textColor: Color,
    rotation: Float = 0f,
    onFieldClick: () -> Unit
) {
    Box(
        modifier = modifier.clickable { onFieldClick() },
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = time,
            style = MaterialTheme.typography.h3,
            color = textColor,
            modifier = Modifier.rotate(rotation)
        )
    }
}

@Preview
@Composable
fun TapFieldPreview() {
    TapField(
        textColor = Color.White, modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .background(
                Color.Black
            ),
        rotation = -180f,
        onFieldClick = {}
    )
}