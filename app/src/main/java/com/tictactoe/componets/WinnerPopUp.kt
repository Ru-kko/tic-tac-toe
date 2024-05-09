package com.tictactoe.componets

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.tictactoe.R
import com.tictactoe.tictactoe.States
import com.tictactoe.ui.theme.Catppuccin

@Composable
fun WinnerPopUp(appear: Boolean, state: States, theme: Catppuccin, onDismiss: () -> Unit) {
    AnimatedVisibility(
        visible = appear,
        enter = scaleIn(),
        exit = scaleOut(),
    ) {
        Dialog(onDismissRequest = onDismiss) {
            Card(colors = CardDefaults.cardColors(containerColor = Color.Transparent)) {
                Column(
                    modifier = Modifier.padding(15.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(5.dp),
                ) {
                    Winner(state = state, theme = theme)
                }
            }
        }
    }
}

@Composable
internal fun Winner(state: States, theme: Catppuccin) {
    val text = when (state) {
        States.Void -> "Draw"
        States.USER -> "You Won"
        States.AI -> "Ai Won"
    }
    val color = when (state) {
        States.Void -> theme.Text
        States.USER -> theme.Red
        States.AI -> theme.Peach
    }

    Icon(
        imageVector = ImageVector.vectorResource(
            when (state) {
                States.Void -> R.drawable.draw
                States.USER -> R.drawable.player_x
                States.AI -> R.drawable.player_o
            }
        ),
        tint = color,
        contentDescription = "Draw",
        modifier = Modifier.size(70.dp)
    )
    Text(
        fontSize = 25.sp,
        color = color,
        text = text
    )
}