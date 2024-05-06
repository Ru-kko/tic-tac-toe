package com.tictactoe.componets

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import com.tictactoe.MainViewModel
import com.tictactoe.ui.theme.TicTacToeTheme

@Composable
fun AppLayout(viewModel: MainViewModel) {
    val theme by viewModel.selectedTheme.collectAsState()

    TicTacToeTheme(theme = theme) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
        ) { p ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                theme.Base,
                                theme.Crust,
                            )
                        )
                    ),
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Tic-Tac-Toe",
                    fontSize = 7.em,
                    color = theme.Text,
                    modifier = Modifier.padding(p)
                )
                Board(viewModel, theme)
                Row(horizontalArrangement = Arrangement.spacedBy(20.dp)) {
                    ThemeSwitch(viewModel)
                    RetryBtn(theme, viewModel)
                }
            }
        }

    }
}