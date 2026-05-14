package com.hrconnect.uikit.presentation.components.progress_bar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hrconnect.uikit.common.theme.HrTheme

@Composable
fun ProgressBar(
    currentPage: Int,
    pageCount: Int,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        repeat(pageCount) { index ->
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(8.dp)
                    .background(
                        color = when {
                            index < currentPage -> HrTheme.colorScheme.primary
                            index == currentPage -> HrTheme.colorScheme.primary.copy(alpha = 0.5f)
                            else -> HrTheme.colorScheme.progressBarContainer
                        },
                        shape = CircleShape
                    )
            )
        }
    }
}