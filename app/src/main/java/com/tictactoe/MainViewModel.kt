package com.tictactoe

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tictactoe.tictactoe.Board
import com.tictactoe.tictactoe.Manger
import com.tictactoe.tictactoe.States
import com.tictactoe.ui.theme.shcemes.Latte
import com.tictactoe.util.settings.UserSettings
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val themePref: UserSettings,
    private val game: Manger
) : ViewModel() {
    val selectedTheme = themePref.getTheme().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(),
        initialValue = Latte()
    )

    fun switch() {
        viewModelScope.launch {
            themePref.switch()
        }
    }

    val board = game.getGame().stateIn(
        viewModelScope,
        SharingStarted.Eagerly,
        Board.getVoidBoard()
    )

    val winner = game.winner().stateIn(
        viewModelScope,
        SharingStarted.Eagerly,
        Manger.WinnerState(false, States.Void, States.USER)
    )

    fun retry() {
        viewModelScope.launch {
            game.retry()
        }
    }

    fun play(x: Int, y:Int) {
        viewModelScope.launch {
            game.play(x, y)
        }
    }
}