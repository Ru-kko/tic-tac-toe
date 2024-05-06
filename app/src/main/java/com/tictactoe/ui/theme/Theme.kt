package com.tictactoe.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun TicTacToeTheme(
    theme: Catppuccin,
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = theme.build(),
        typography = Typography,
        content = content
    )
}