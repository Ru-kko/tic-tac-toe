package com.tictactoe.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.ui.graphics.Color

abstract class Catppuccin {
    abstract val Surface2: Color
    abstract val Mantle: Color
    abstract val Crust: Color
    abstract val Base: Color
    abstract val Text: Color
    abstract val Peach: Color
    abstract val Red: Color

    abstract val Icon: Int

    abstract fun build() : ColorScheme
}
