package com.tictactoe.ui.theme.shcemes

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.ui.graphics.Color
import com.tictactoe.R
import com.tictactoe.ui.theme.Catppuccin

class Mocha : Catppuccin() {
    override val Surface2: Color = Color(0xFF585B70)
    override val Mantle: Color = Color(0xFF181825)
    override val Crust: Color = Color(0xFF11111B)
    override val Base: Color = Color(0xFF1E1E2E)
    override val Text: Color = Color(0xFFCDD6F4)
    override val Peach: Color = Color(0xFFFAB387)
    override val Red: Color = Color(0xFFF38BA8)

    override val Icon: Int = R.drawable.moon_svgrepo_com

    override fun build(): ColorScheme {
        return darkColorScheme(
            primary = Color(0xFFBCC2FF),
            onPrimary = Color(0xFF242B61),
            secondary = Color(0xFFC4C5DD),
            onSecondary = Color(0xFF2D2F42),
            tertiary = Color(0xFFE6BAD6),
            onTertiary = Color(0xFF45263D),
            error = Color(0xFFFFB4AB),
            onError = Color(0xFF690005),
            primaryContainer = Color(0xFF3B4279),
            onPrimaryContainer = Color(0xFFDFE0FF),
            secondaryContainer = Color(0xFF444559),
            onSecondaryContainer = Color(0xFFE0E0F9),
            tertiaryContainer = Color(0xFF5E3C54),
            onTertiaryContainer = Color(0xFFFFD7F0),
            errorContainer = Color(0xFF93000A),
            onErrorContainer = Color(0xFFFFDAD6),
            background = Color(0xFF131318),
            onBackground = Color(0xFFE4E1E9)
        )
    }

}