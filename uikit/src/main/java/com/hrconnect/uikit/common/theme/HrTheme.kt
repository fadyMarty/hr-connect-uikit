package com.hrconnect.uikit.common.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

@Composable
fun HrTheme(
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(
        LocalHrColorScheme provides LightColorScheme
    ) {
        MaterialTheme(
            content = content
        )
    }
}

object HrTheme {

    val colorScheme: HrColorScheme
        @Composable
        get() = LocalHrColorScheme.current
}