package com.hynekbraun.chesstimer.data.local.timedatastore

import android.content.Context
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStoreFile
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

private const val TIMER_APP_DATASTORE = "timer_app_datastore"
private val TIME_SELECTED = intPreferencesKey("current_time_selected")

@Singleton
class TimeDataStore @Inject constructor(
    @ApplicationContext private val context: Context
) {
    private val dataStore = PreferenceDataStoreFactory.create {
        context.preferencesDataStoreFile(TIMER_APP_DATASTORE)
    }

    val selectedTime: Flow<Int> = dataStore.data
        .map { preferences ->
            preferences[TIME_SELECTED] ?: 0
        }

    suspend fun setSelectedTime(selectedTime: Int) {
        dataStore.edit { preferences ->
            preferences[TIME_SELECTED] = selectedTime
        }
    }
}