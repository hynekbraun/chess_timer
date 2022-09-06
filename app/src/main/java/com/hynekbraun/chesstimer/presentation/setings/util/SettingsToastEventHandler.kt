package com.hynekbraun.chesstimer.presentation.setings.util

import android.content.Context
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.hynekbraun.chesstimer.R

sealed class SettingsToastEventHandler(@StringRes val errorId: Int) {
    data class OnDeleteEvent(@StringRes val messageId: Int = R.string.settings_toast_delete_sucessfull) :
        SettingsToastEventHandler(errorId = messageId)

    @Composable
    fun asString(): String {
        return stringResource(errorId)
    }

    fun asString(context: Context): String {
        return context.getString(errorId)
    }
}