package com.hynekbraun.chesstimer.presentation.setings.composables

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
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

//Later add checkbox to see chosen time

@Composable
fun TimeItem(
    modifier: Modifier = Modifier,
    time: TimeModel,
    onDelete: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(4.dp),
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
                fontSize = 12.sp,
                fontWeight = FontWeight.Light,
                color = Color.Gray
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
    Box(modifier = Modifier.fillMaxSize()) {
        TimeItem(
            time = TimeModel(
                id = 0,
                name = "Some name asd as dasd as d",
                timeStart = 200L,
                timeGain = 200L
            )
        ) {
        }
    }
}