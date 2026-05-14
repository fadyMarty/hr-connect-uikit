package com.hrconnect.uikit.presentation.components.bottom_bar

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.graphics.shadow.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hrconnect.uikit.common.theme.HrTheme
import com.hrconnect.uikit.common.theme.Manrope

@Composable
fun <T> BottomBar(
    items: List<BottomBarItem<T>>,
    onItemClick: (BottomBarItem<T>) -> Unit,
    modifier: Modifier = Modifier,
) {
    val bottomBarShape = RoundedCornerShape(
        topStart = 8.dp,
        topEnd = 8.dp
    )

    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(80.dp)
            .dropShadow(
                shape = bottomBarShape,
                shadow = Shadow(
                    offset = DpOffset(0.dp, (-4).dp),
                    radius = 12.dp,
                    alpha = 0.05f
                )
            )
            .clip(bottomBarShape)
            .background(HrTheme.colorScheme.container)
            .border(
                width = 1.dp,
                color = HrTheme.colorScheme.bottomBarBorder,
                shape = bottomBarShape
            )
    ) {
        items.forEach { item ->
            val contentColor = if (item.selected) {
                HrTheme.colorScheme.primaryVariant
            } else {
                HrTheme.colorScheme.bottomBarContent
            }

            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .clickable(
                        interactionSource = null,
                        indication = ripple(bounded = false)
                    ) {
                        onItemClick(item)
                    },
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Icon(
                    modifier = Modifier.size(24.dp),
                    imageVector = item.icon,
                    contentDescription = null,
                    tint = contentColor
                )
                Text(
                    text = item.label,
                    style = TextStyle(
                        fontFamily = Manrope,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 11.sp,
                        lineHeight = 16.5.sp,
                        letterSpacing = 0.sp,
                        color = contentColor
                    )
                )
            }
        }
    }
}