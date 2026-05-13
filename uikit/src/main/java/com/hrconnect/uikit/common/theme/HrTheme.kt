package com.hrconnect.uikit.common.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

@Composable
fun HrTheme(
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(
        LocalHrColorScheme provides LightColorScheme,
        LocalHrTypography provides Typography
    ) {
        MaterialTheme(
            colorScheme = mapMaterialColorScheme(
                hrColorScheme = LightColorScheme
            ),
            content = content
        )
    }
}

object HrTheme {

    val colorScheme: HrColorScheme
        @Composable
        get() = LocalHrColorScheme.current

    val typography: HrTypography
        @Composable
        get() = LocalHrTypography.current
}

private fun mapMaterialColorScheme(
    hrColorScheme: HrColorScheme,
): ColorScheme {
    return lightColorScheme(
        primary = hrColorScheme.primary,
        onPrimary = hrColorScheme.onPrimary,
        secondary = hrColorScheme.secondary,
        tertiary = hrColorScheme.tertiary,
        error = hrColorScheme.error,
        background = hrColorScheme.background,
        onBackground = hrColorScheme.onBackground,
        surfaceContainer = hrColorScheme.container
    )
}