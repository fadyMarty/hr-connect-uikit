package com.hrconnect.uikit.presentation.components.inputs

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.hrconnect.uikit.common.theme.HrTheme
import com.hrconnect.uikit.common.theme.Manrope

@Composable
fun Input(
    state: TextFieldState,
    modifier: Modifier = Modifier,
    label: String? = null,
    supportingText: String? = null,
    placeholder: String? = null,
    isError: Boolean = false,
    enabled: Boolean = true,
    focused: Boolean = false,
    singleLine: Boolean = true,
    leadingIcon: ImageVector? = null,
    trailingIcon: ImageVector? = null,
) {
    InputLayout(
        modifier = modifier,
        label = label,
        supportingText = supportingText,
        isError = isError,
        enabled = enabled,
        focused = focused
    ) { styleModifier, interactionSource ->
        BasicTextField(
            modifier = styleModifier,
            state = state,
            interactionSource = interactionSource,
            enabled = enabled,
            lineLimits = if (singleLine) {
                TextFieldLineLimits.SingleLine
            } else {
                TextFieldLineLimits.Default
            },
            textStyle = TextStyle(
                fontFamily = Manrope,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                lineHeight = 1.em,
                letterSpacing = 0.sp,
                color = when {
                    enabled -> HrTheme.colorScheme.onBackground
                    else -> HrTheme.colorScheme.secondary
                }
            ),
            cursorBrush = SolidColor(HrTheme.colorScheme.primary),
            decorator = { innerTextField ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    if (leadingIcon != null) {
                        Icon(
                            modifier = Modifier.size(22.dp),
                            imageVector = leadingIcon,
                            contentDescription = null,
                            tint = if (isError) {
                                HrTheme.colorScheme.error
                            } else {
                                HrTheme.colorScheme.secondary
                            }
                        )
                    }
                    Box(
                        modifier = Modifier.weight(1f),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        if (state.text.isEmpty() && placeholder != null) {
                            Text(
                                text = placeholder,
                                style = TextStyle(
                                    fontFamily = Manrope,
                                    fontWeight = FontWeight.Normal,
                                    fontSize = 16.sp,
                                    lineHeight = 1.em,
                                    letterSpacing = 0.sp,
                                    color = HrTheme.colorScheme.placeholder
                                )
                            )
                        }
                        innerTextField()
                    }
                    if (trailingIcon != null) {
                        Icon(
                            modifier = Modifier.size(22.dp),
                            imageVector = trailingIcon,
                            contentDescription = null,
                            tint = if (isError) {
                                HrTheme.colorScheme.error
                            } else {
                                HrTheme.colorScheme.secondary
                            }
                        )
                    }
                }
            }
        )
    }
}

@Preview
@Composable
private fun InputPreview() {
    HrTheme {
        Input(
            state = rememberTextFieldState(),
            label = "Default Input",
            placeholder = "Enter text..."
        )
    }
}