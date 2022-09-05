package com.hynekbraun.chesstimer.presentation.composables

import androidx.compose.foundation.Indication
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.hynekbraun.chesstimer.R

@Composable
fun CustomTopAppBar(
    modifier: Modifier = Modifier,
    onNavigateBack: () -> Unit,
    showAddTimer: Boolean = false,
) {
    TopAppBar(
        title = {
            Text(
                text = stringResource(R.string.settings),
                modifier = Modifier
                    .fillMaxWidth(),
            )
        },
        backgroundColor = MaterialTheme.colors.primary,
        actions = {//button at the end
            if (showAddTimer) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = stringResource(id = R.string.content_desc_add_time),
                    modifier = modifier.padding(end = 4.dp)
                )
            }
        },
        navigationIcon = {//button at the beginning
            Icon(
                painter = painterResource(id = R.drawable.ic_back_24),
                contentDescription = stringResource(R.string.content_desc_go_back),
                modifier = Modifier
                    .clickable(
                        indication = null,
                        interactionSource = remember {
                            MutableInteractionSource()
                        }
                    ) {
                        onNavigateBack()
                    }
                    .padding(start = 4.dp)
            )
        }
    )
}
