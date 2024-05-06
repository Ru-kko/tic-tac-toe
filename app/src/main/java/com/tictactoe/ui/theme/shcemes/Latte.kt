package com.tictactoe.ui.theme.shcemes

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import com.tictactoe.ui.theme.Catppuccin
import com.tictactoe.R

class Latte : Catppuccin() {
    override val Surface2: Color = Color(0xFFACB0BE)
    override val Mantle: Color = Color(0xFFE6E9EF)
    override val Crust: Color = Color(0xFFDCE0E8)
    override val Base: Color = Color(0xFFEFF1F5)
    override val Text: Color = Color(0xFF4C4F69)
    override val Peach: Color = Color(0xFFFE640B)
    override val Red: Color = Color(0xFFD20F39)

    override val Icon: Int = R.drawable.sun_svgrepo_com

    override fun build(): ColorScheme {
        return lightColorScheme(
            primary = Color(0xFF35618E),
            onPrimary = Color(0xFFFFFFFF),
            primaryContainer = Color(0xFFD1E4FF),
            onPrimaryContainer = Color(0xFF001D36),
            secondary = Color(0xFF535F70),
            onSecondary = Color(0xFFFFFFFF),
            secondaryContainer = Color(0xFFD6E3F7),
            onSecondaryContainer = Color(0xFF101C2B),
            tertiary = Color(0xFF6B5778),
            onTertiary = Color(0xFFFFFFFF),
            tertiaryContainer = Color(0xFFF2DAFF),
            onTertiaryContainer = Color(0xFF251432),
            error = Color(0xFFBA1A1A),
            onError = Color(0xFFFFFFFF),
            errorContainer = Color(0xFFFFDAD6),
            onErrorContainer = Color(0xFF410002)
        )
    }
}