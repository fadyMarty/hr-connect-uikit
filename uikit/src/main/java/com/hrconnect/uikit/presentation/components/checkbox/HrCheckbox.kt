package com.hrconnect.uikit.presentation.components.checkbox

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hrconnect.uikit.R
import com.hrconnect.uikit.common.theme.HrTheme

@Composable
fun HrCheckbox(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    label: AnnotatedString? = null,
    enabled: Boolean = true,
) {
    Row(
        modifier = modifier.alpha(
            alpha = if (enabled) 1f else 0.5f
        ),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Box(
            modifier = Modifier
                .size(24.dp)
                .clip(RoundedCornerShape(4.dp))
                .background(
                    color = when {
                        checked -> HrTheme.colorScheme.primary
                        enabled -> HrTheme.colorScheme.background
                        else -> HrTheme.colorScheme.checkboxContainerDisabled
                    }
                )
                .then(
                    if (!checked) {
                        Modifier.border(
                            width = 2.dp,
                            color = if (enabled) {
                                HrTheme.colorScheme.description
                            } else {
                                HrTheme.colorScheme.stroke
                            },
                            shape = RoundedCornerShape(4.dp)
                        )
                    } else Modifier
                )
                .clickable(
                    enabled = enabled,
                    onClick = {
                        onCheckedChange(!checked)
                    }
                ),
            contentAlignment = Alignment.Center
        ) {
            if (checked) {
                Icon(
                    modifier = Modifier.size(9.51.dp),
                    imageVector = ImageVector.vectorResource(R.drawable.ic_check),
                    contentDescription = null,
                    tint = HrTheme.colorScheme.onPrimary
                )
            }
        }
        if (label != null) {
            Text(
                text = label,
                style = HrTheme.typography.bodyMedium
            )
        }
    }
}

@Preview
@Composable
private fun HrCheckboxPreview() {
    HrTheme {
        HrCheckbox(
            checked = true,
            onCheckedChange = {},
            label = AnnotatedString("Checked")
        )
    }
}