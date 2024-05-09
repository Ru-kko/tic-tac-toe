package com.tictactoe.componets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.tictactoe.MainViewModel
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tictactoe.ui.theme.Catppuccin

@Composable
fun Board(viewModel: MainViewModel, theme: Catppuccin, enabled: Boolean = true) {
    val board by viewModel.board.collectAsState()
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f)
            .padding(20.dp)
            .background(theme.Surface2, shape = RoundedCornerShape(6))
    ) {
        board.forEachIndexed { y, it ->
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(PaddingValues(0.dp, 5.dp))
            ) {
                it.forEachIndexed { x, st ->
                    BoardCell(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxSize()
                            .padding(PaddingValues(5.dp, 0.dp))
                            .background(theme.Mantle, getRoundedCorners(x, y)),
                        state = st,
                        onClick = { if (enabled) viewModel.play(x, y) },
                        theme = theme
                    )
                }
            }
        }
    }
}

fun getRoundedCorners(x: Int, y: Int): RoundedCornerShape {
    var topL = 8
    var topR = 8
    var bottomL = 8
    var bottomR = 8

    if (y == 0) {
        topL = 17
        topR = 17
    }
    if (y == 2) {
        bottomL = 17
        bottomR = 17
    }

    if (x == 0) {
        topL = 17
        bottomL = 17
    }
    if (x == 2) {
        topR = 17
        bottomR = 17
    }

    if (x == 0 && y == 0) {
        topL = 21
    } else if (x == 0 && y == 2) {
        bottomL = 21
    } else if (x == 2 && y == 0) {
        topR = 21
    } else if (x == 2 && y == 2) {
        bottomR = 21
    }

    return RoundedCornerShape(topL, topR, bottomR, bottomL)
}