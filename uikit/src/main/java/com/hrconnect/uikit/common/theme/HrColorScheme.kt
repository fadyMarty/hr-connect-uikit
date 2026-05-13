package com.hrconnect.uikit.common.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
data class HrColorScheme(
    val primary: Color,
    val primaryVariant: Color,
    val primaryContainer: Color,
    val onPrimaryContainer: Color,
    val onPrimary: Color,
    val secondary: Color,
    val tertiary: Color,
    val error: Color,
    val onError: Color,
    val background: Color,
    val onBackground: Color,
    val onBackgroundVariant: Color,
    val container: Color,
    val inputContainerDisabled: Color,
    val checkboxContainerDisabled: Color,
    val stroke: Color,
    val fieldLabel: Color,
    val placeholder: Color,
    val description: Color,
    val divider: Color,
)

val LightColorScheme = HrColorScheme(
    primary = Color(0xFF004AC6),
    primaryVariant = Color(0xFF2563EB),
    primaryContainer = Color(0xFFD0E1FB),
    onPrimaryContainer = Color(0xFF54647A),
    onPrimary = Color.White,
    secondary = Color(0xFF505F76),
    tertiary = Color(0xFF943700),
    error = Color(0xFFBA1A1A),
    onError = Color.White,
    background = Color(0xFFFAF8FF),
    onBackground = Color(0xFF191B23),
    onBackgroundVariant = Color(0xFF0B1C30),
    container = Color.White,
    inputContainerDisabled = Color(0xFFF3F3FE),
    checkboxContainerDisabled = Color(0xFFEDEDF9),
    stroke = Color(0xFFC3C6D7),
    fieldLabel = Color(0xFF434655),
    placeholder = Color(0xFF6B7280),
    description = Color(0xFF737686),
    divider = Color(0xFFF8FAFC)
)

val LocalHrColorScheme = staticCompositionLocalOf {
    LightColorScheme
}