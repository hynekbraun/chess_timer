package com.hynekbraun.chesstimer.presentation.setings.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hynekbraun.chesstimer.R
import com.hynekbraun.chesstimer.domain.TimeModel
import com.hynekbraun.chesstimer.presentation.setings.util.SettingsModel

//Later add checkbox to see chosen time

@Composable
fun TimeItem(
    modifier: Modifier = Modifier,
    time: SettingsModel,
    onDelete: () -> Unit,
    isSelected: Boolean = false,
    onSelected: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(if (isSelected) Color.LightGray else MaterialTheme.colors.background)
            .padding(4.dp)
            .clickable(
                interactionSource = remember {
                    MutableInteractionSource()
                },
                indication = null
            ) { onSelected() },
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(0.6f),
            text = time.name,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.h5
        )
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = stringResource(
                    id = R.string.settings_screen_time,
                    time.timeStart,
                    time.timeGain
                ),
                style = MaterialTheme.typography.caption
            )
            Spacer(modifier = Modifier.width(4.dp))
            IconButton(onClick = { onDelete() }) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = stringResource(R.string.content_desc_delete_time)
                )
            }
        }
    }
}

@Preview
@Composable
fun TimeItemPreview() {
    Surface() {
        TimeItem(
            time = SettingsModel(
                id = 0,
                name = "Some name asd as dasd as d",
                timeStart = "00:00:00",
                timeGain = "00:00:00",
            ),
            onDelete = {},
            isSelected = true,
            onSelected = {}
        )
    }
}