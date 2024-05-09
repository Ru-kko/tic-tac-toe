package com.tictactoe.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStoreFile
import com.tictactoe.tictactoe.Game
import com.tictactoe.tictactoe.Manger
import com.tictactoe.tictactoe.impl.GameImpl
import com.tictactoe.util.settings.ImplUserSettings
import com.tictactoe.util.settings.UserSettings
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SettingsModule {
    @Singleton
    @Provides
    fun provideDataStore(@ApplicationContext context: Context): DataStore<Preferences> {
        return PreferenceDataStoreFactory.create(
            corruptionHandler = ReplaceFileCorruptionHandler(
                produceNewData = { emptyPreferences() }
            ), produceFile = { context.preferencesDataStoreFile("user_data") }
        )
    }

    @Singleton
    @Provides
    fun provideGame(): Game = GameImpl()

    @Singleton
    @Provides
    fun provideGameManager(game: Game): Manger = Manger(game)

    @Singleton
    @Provides
    fun provideUserSettings(dataStore: DataStore<Preferences>) : UserSettings = ImplUserSettings(dataStore)
}