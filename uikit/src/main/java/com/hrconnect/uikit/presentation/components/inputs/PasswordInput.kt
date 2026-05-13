package com.hrconnect.uikit.presentation.components.inputs

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicSecureTextField
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.TextObfuscationMode
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.hrconnect.uikit.R
import com.hrconnect.uikit.common.theme.HrTheme
import com.hrconnect.uikit.common.theme.Manrope

@Composable
fun PasswordInput(
    state: TextFieldState,
    isPasswordVisible: Boolean,
    onTogglePasswordVisibility: () -> Unit,
    modifier: Modifier = Modifier,
    label: String? = null,
    supportingText: String? = null,
    placeholder: String? = null,
    isError: Boolean = false,
    enabled: Boolean = true,
    focused: Boolean = false,
    leadingIcon: ImageVector? = null,
) {
    InputLayout(
        modifier = modifier,
        label = label,
        supportingText = supportingText,
        isError = isError,
        enabled = enabled,
        focused = focused
    ) { styleModifier, interactionSource ->
        BasicSecureTextField(
            modifier = styleModifier,
            state = state,
            textObfuscationMode = if (isPasswordVisible) {
                TextObfuscationMode.Visible
            } else {
                TextObfuscationMode.Hidden
            },
            textObfuscationCharacter = '•',
            enabled = enabled,
            interactionSource = interactionSource,
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
                    Icon(
                        modifier = Modifier
                            .size(22.dp)
                            .clickable(
                                interactionSource = null,
                                indication = ripple(bounded = false),
                                onClick = onTogglePasswordVisibility
                            ),
                        imageVector = if (isPasswordVisible) {
                            ImageVector.vectorResource(R.drawable.ic_visibility)
                        } else {
                            ImageVector.vectorResource(R.drawable.ic_visibility_off)
                        },
                        contentDescription = null,
                        tint = if (isError) {
                            HrTheme.colorScheme.error
                        } else {
                            HrTheme.colorScheme.secondary
                        }
                    )
                }
            }
        )
    }
}

@Preview
@Composable
private fun InputPreview() {
    HrTheme {
        PasswordInput(
            state = rememberTextFieldState("secret123"),
            isPasswordVisible = true,
            onTogglePasswordVisibility = {}
        )
    }
}