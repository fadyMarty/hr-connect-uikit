package com.hrconnect.uikit.presentation.components.inputs

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hrconnect.uikit.common.theme.HrTheme
import com.hrconnect.uikit.common.theme.Manrope

@Composable
fun InputLayout(
    modifier: Modifier = Modifier,
    label: String? = null,
    supportingText: String? = null,
    isError: Boolean = false,
    enabled: Boolean = true,
    focused: Boolean = false,
    input: @Composable (Modifier, MutableInteractionSource) -> Unit,
) {
    val interactionSource = remember {
        MutableInteractionSource()
    }
    val isFocused by interactionSource.collectIsFocusedAsState()

    val inputStyleModifier = Modifier
        .fillMaxWidth()
        .background(
            color = if (enabled) {
                HrTheme.colorScheme.background
            } else {
                HrTheme.colorScheme.inputContainerDisabled
            },
            shape = RoundedCornerShape(8.dp)
        )
        .border(
            width = if (focused || isFocused || isError) {
                2.dp
            } else 1.dp,
            color = when {
                isError -> HrTheme.colorScheme.error
                focused || isFocused -> HrTheme.colorScheme.primary
                else -> HrTheme.colorScheme.stroke
            },
            shape = RoundedCornerShape(8.dp)
        )
        .padding(
            horizontal = 16.dp,
            vertical = 12.dp
        )

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        if (label != null) {
            Text(
                text = label,
                style = HrTheme.typography.fieldLabel,
                color = when {
                    isError -> HrTheme.colorScheme.error
                    focused || isFocused -> HrTheme.colorScheme.primary
                    enabled -> HrTheme.colorScheme.fieldLabel
                    else -> HrTheme.colorScheme.description
                }
            )
        }
        input(inputStyleModifier, interactionSource)
        if (supportingText != null) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = supportingText,
                style = TextStyle(
                    fontFamily = Manrope,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp,
                    lineHeight = 16.sp,
                    letterSpacing = 0.sp
                ),
                color = when {
                    isError -> HrTheme.colorScheme.error
                    enabled -> HrTheme.colorScheme.fieldLabel
                    else -> HrTheme.colorScheme.description
                }
            )
        }
    }
}