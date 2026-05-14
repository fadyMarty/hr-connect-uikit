package com.hrconnect.uikit.presentation.components.bottom_bar

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomBarItem<T>(
    val selected: Boolean,
    val icon: ImageVector,
    val label: String,
    val route: T,
)
