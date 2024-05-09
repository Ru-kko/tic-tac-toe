package com.tictactoe.componets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.tictactoe.R
import com.tictactoe.tictactoe.States
import com.tictactoe.ui.theme.Catppuccin

@Composable
fun BoardCell(modifier: Modifier, state: States, onClick: () -> Unit = {}, theme: Catppuccin) {
    if (state == States.Void) {
        Button(
            onClick = onClick, modifier = modifier.alpha(0f)
        ) {}

        return
    }

    Box(
        modifier = modifier
    ) {
        if (state == States.AI) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.player_o),
                contentDescription = "Player o",
                tint = theme.Peach,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)
                    .background(Color.Transparent)
            )
        } else if (state == States.USER) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.player_x),
                contentDescription = "Player x",
                tint = theme.Red,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)
                    .background(Color.Transparent)
            )
        }
    }
}