package com.tictactoe.componets

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.tictactoe.MainViewModel

@Composable
fun ThemeSwitch(viewModel: MainViewModel) {
    val theme by viewModel.selectedTheme.collectAsState()
    Button(
        colors = ButtonDefaults.buttonColors(containerColor = theme.Surface2),
        modifier = Modifier.size(50.dp),
        contentPadding = PaddingValues(5.dp),
        onClick = { viewModel.switch() }
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(theme.Icon),
            contentDescription = "Them switch",
            tint = theme.Red,
            modifier = Modifier.fillMaxSize()
        )
    }
}