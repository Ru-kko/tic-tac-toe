package com.tictactoe.util.settings

import androidx.datastore.preferences.core.stringPreferencesKey
import com.tictactoe.ui.theme.Catppuccin
import kotlinx.coroutines.flow.Flow

val THEME_KEY = stringPreferencesKey("settings")

interface UserSettings {
    fun getTheme(): Flow<Catppuccin>
    suspend fun switch()
}
