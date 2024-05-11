package com.tictactoe.componets

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tictactoe.MainViewModel
import com.tictactoe.R
import com.tictactoe.tictactoe.States
import com.tictactoe.ui.theme.Catppuccin

@Composable
fun CurrentTurn(viewModel: MainViewModel, theme: Catppuccin) {
    val winner by viewModel.winner.collectAsState()

    val shape = RoundedCornerShape(20.dp)
    Card(
        modifier = Modifier
            .background(theme.Surface2, shape = shape)
            .border(5.dp, theme.Crust ,shape)
            .clip(shape),
        colors = CardDefaults.cardColors(containerColor = theme.Surface2)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(15.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(15.dp)
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(
                    when (winner.turn) {
                        States.AI -> R.drawable.player_o
                        States.USER, States.Void -> R.drawable.player_x
                    }
                ), contentDescription = "Actual player",
                tint = when (winner.turn) {
                    States.AI -> theme.Peach
                    States.USER, States.Void -> theme.Red
                },
                modifier = Modifier
                    .size(70.dp)
            )
            
            Text(text = "Current Turn", fontSize = 20.sp, color = theme.Text)
        }
    }
}