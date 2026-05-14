package com.hrconnect.uikit.presentation.components.avatar

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.hrconnect.uikit.common.theme.HrTheme
import com.hrconnect.uikit.common.theme.Manrope

@Composable
fun Avatar(
    displayText: String,
    modifier: Modifier = Modifier,
    image: Painter? = null,
    onClick: (() -> Unit)? = null,
) {
    Box(
        modifier = modifier
            .size(60.dp)
            .clip(CircleShape)
            .border(
                width = 2.dp,
                color = if (image != null) {
                    HrTheme.colorScheme.primaryVariant
                } else HrTheme.colorScheme.border,
                shape = CircleShape
            )
            .clickable(
                enabled = onClick != null,
                onClick = { onClick?.invoke() }
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = displayText,
            style = TextStyle(
                fontFamily = Manrope,
                fontWeight = FontWeight.Bold,
                color = HrTheme.colorScheme.onBackgroundVariant
            )
        )
        if (image != null) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = image,
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }
    }
}