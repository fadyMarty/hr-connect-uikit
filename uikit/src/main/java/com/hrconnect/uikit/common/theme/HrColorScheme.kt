package com.hrconnect.uikit.common.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
data class HrColorScheme(
    val primary: Color,
    val secondary: Color,
    val tertiary: Color,
    val error: Color,
)

val LightColorScheme = HrColorScheme(
    primary = HrPalette.Primary,
    secondary = HrPalette.Secondary,
    tertiary = HrPalette.Tertiary,
    error = HrPalette.Error
)

internal val LocalHrColorScheme = staticCompositionLocalOf {
    LightColorScheme
}