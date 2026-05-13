package com.hrconnect.storybook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.hrconnect.storybook.presentation.storybook.StorybookScreen
import com.hrconnect.uikit.common.theme.HrTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HrTheme {
                StorybookScreen()
            }
        }
    }
}