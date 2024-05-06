package com.tictactoe.componets

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.tictactoe.MainViewModel
import com.tictactoe.R
import com.tictactoe.ui.theme.Catppuccin

@Composable
fun RetryBtn(theme: Catppuccin, viewModel: MainViewModel) {
    Button(
        colors = ButtonDefaults.buttonColors(containerColor = theme.Surface2),
        modifier = Modifier.size(50.dp),
        contentPadding = PaddingValues(5.dp),
        onClick = { viewModel.retry() }
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.retry),
            contentDescription = "Retry the game",
            tint = theme.Peach,
            modifier = Modifier.fillMaxSize()
        )
    }
}