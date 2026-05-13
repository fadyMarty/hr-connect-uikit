package com.hrconnect.uikit.presentation.components.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.shadow.Shadow
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hrconnect.uikit.R
import com.hrconnect.uikit.common.theme.HrTheme
import com.hrconnect.uikit.common.theme.Manrope

@Composable
fun ListCard(
    title: String,
    company: String,
    employment: String,
    minSalary: Int,
    maxSalary: Int,
    applicantsCount: Int,
    isActive: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .dropShadow(
                shape = RoundedCornerShape(12.dp),
                shadow = Shadow(
                    offset = DpOffset(0.dp, 4.dp),
                    radius = 12.dp,
                    color = Color.Black,
                    alpha = 0.05f
                )
            )
            .clip(RoundedCornerShape(12.dp))
            .background(HrTheme.colorScheme.container)
            .border(
                width = 1.dp,
                color = HrTheme.colorScheme.background,
                shape = RoundedCornerShape(12.dp)
            )
            .clickable(onClick = onClick)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    text = title,
                    style = HrTheme.typography.subheader
                )
                Text(
                    text = "$company • $employment",
                    style = HrTheme.typography.bodySmall,
                    color = HrTheme.colorScheme.secondary
                )
            }
            if (isActive) {
                Box(
                    modifier = Modifier
                        .height(24.dp)
                        .clip(CircleShape)
                        .background(HrTheme.colorScheme.primaryContainer)
                        .padding(horizontal = 12.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Active",
                        style = TextStyle(
                            fontFamily = Manrope,
                            fontWeight = FontWeight.Medium,
                            fontSize = 12.sp,
                            lineHeight = 16.sp,
                            letterSpacing = 0.sp,
                            color = HrTheme.colorScheme.onPrimaryContainer
                        )
                    )
                }
            }
        }
        HorizontalDivider(
            thickness = 1.dp,
            color = HrTheme.colorScheme.divider
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier.size(16.5.dp),
                    imageVector = ImageVector.vectorResource(R.drawable.ic_payments),
                    contentDescription = null,
                    tint = HrTheme.colorScheme.secondary
                )
                Text(
                    text = "$${minSalary}k - $${maxSalary}k",
                    style = HrTheme.typography.fieldLabel
                )
            }
            Row(
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier.size(18.dp),
                    imageVector = ImageVector.vectorResource(R.drawable.ic_groups),
                    contentDescription = null,
                    tint = HrTheme.colorScheme.secondary
                )
                Text(
                    text = "$applicantsCount Applicants",
                    style = HrTheme.typography.bodySmall
                )
            }
        }
    }
}

@Preview
@Composable
private fun ListCardPreview() {
    HrTheme {
        ListCard(
            title = "Senior Product Designer",
            company = "Product Team",
            employment = "Full-time",
            minSalary = 120,
            maxSalary = 160,
            applicantsCount = 24,
            isActive = true,
            onClick = {}
        )
    }
}