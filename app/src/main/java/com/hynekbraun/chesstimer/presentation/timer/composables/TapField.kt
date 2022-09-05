package com.hynekbraun.chesstimer.presentation.timer.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hynekbraun.chesstimer.R


@Composable
fun TapField(
    modifier: Modifier = Modifier,
    time: String = stringResource(R.string.time_placeholder_zero_zero_zero),
    textColor: Color,
    rotation: Float = 0f,
    onFieldClick: () -> Unit,
    moves: Int
) {
    Box(
        modifier = modifier
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
            ) { onFieldClick() }
            .rotate(rotation),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = time,
            style = MaterialTheme.typography.h2,
            color = textColor,
        )
        Text(
            text = stringResource(id = R.string.timer_moves_count, moves),
            modifier = Modifier.align(Alignment.BottomCenter),
            style = MaterialTheme.typography.subtitle1,
            color = textColor
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
        onFieldClick = {},
        moves = 5
    )
}