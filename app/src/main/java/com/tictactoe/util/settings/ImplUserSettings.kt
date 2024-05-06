package com.tictactoe.util.settings

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStore
import com.tictactoe.ui.theme.Catppuccin
import com.tictactoe.ui.theme.shcemes.Latte
import com.tictactoe.ui.theme.shcemes.Mocha
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ImplUserSettings(private val dataStore: DataStore<Preferences>) : UserSettings {
    override fun getTheme(): Flow<Catppuccin> {
        return dataStore.data.catch { emit(emptyPreferences()) }.map {
            when (ThemeOptions.valueOf(it[THEME_KEY] ?: ThemeOptions.SYSTEM.toString())) {
                ThemeOptions.DARK_MODE -> Mocha()
                ThemeOptions.LIGHT_MODE -> Latte()
                ThemeOptions.SYSTEM -> Latte()
            }
        }
    }

    override suspend fun switch() {
        dataStore.edit { pref ->
            val prev = ThemeOptions.valueOf(pref[THEME_KEY] ?: ThemeOptions.SYSTEM.toString())

            pref[THEME_KEY] = when (prev) {
                ThemeOptions.SYSTEM -> ThemeOptions.DARK_MODE
                ThemeOptions.LIGHT_MODE -> ThemeOptions.DARK_MODE
                ThemeOptions.DARK_MODE -> ThemeOptions.LIGHT_MODE
            }.toString()
        }
    }
}