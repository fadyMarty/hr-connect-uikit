package com.hrconnect.storybook.presentation.storybook

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.hrconnect.storybook.R
import com.hrconnect.uikit.presentation.components.avatar.Avatar
import com.hrconnect.uikit.presentation.components.buttons.DestructiveButton
import com.hrconnect.uikit.presentation.components.buttons.PrimaryButton
import com.hrconnect.uikit.presentation.components.buttons.SecondaryButton
import com.hrconnect.uikit.presentation.components.cards.ListCard
import com.hrconnect.uikit.presentation.components.checkbox.HrCheckbox
import com.hrconnect.uikit.presentation.components.inputs.Input
import com.hrconnect.uikit.presentation.components.inputs.PasswordInput
import com.hrconnect.uikit.presentation.components.select.Select

@Composable
fun StorybookScreen() {
    Scaffold { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(
                horizontal = 20.dp,
                vertical = 24.dp
            )
        ) {
            item {
                PrimaryButton(
                    label = "Primary Default",
                    onClick = {}
                )
            }
            item {
                PrimaryButton(
                    label = "Primary Disabled",
                    onClick = {},
                    enabled = false
                )
            }
            item {
                PrimaryButton(
                    label = "Primary Loading",
                    onClick = {},
                    isLoading = true
                )
            }
            item {
                SecondaryButton(
                    label = "Secondary",
                    onClick = {}
                )
            }
            item {
                DestructiveButton(
                    label = "Destructive Solid",
                    onClick = {}
                )
            }
            item {
                Input(
                    state = rememberTextFieldState(),
                    label = "Default Input",
                    placeholder = "Enter text..."
                )
            }
            item {
                Input(
                    state = rememberTextFieldState("Active typing state"),
                    label = "Focused State",
                    focused = true
                )
            }
            item {
                Input(
                    state = rememberTextFieldState("Wrong data"),
                    label = "Error State",
                    supportingText = "Invalid input",
                    isError = true
                )
            }
            item {
                Input(
                    state = rememberTextFieldState("Cannot edit this"),
                    label = "Disabled Input",
                    enabled = false
                )
            }
            item {
                PasswordInput(
                    state = rememberTextFieldState("secret123"),
                    label = "Password Field",
                    isPasswordVisible = true,
                    onTogglePasswordVisibility = {}
                )
            }
            item {
                PasswordInput(
                    state = rememberTextFieldState("secret123"),
                    label = "Password Field",
                    isPasswordVisible = false,
                    onTogglePasswordVisibility = {}
                )
            }
            item {
                Select(
                    items = listOf(
                        "Engineering",
                        "Department 1",
                        "Department 2",
                        "Department 3"
                    ),
                    selectedItem = "Engineering",
                    onItemClick = {},
                    label = "Select Department"
                )
            }
            item {
                HrCheckbox(
                    checked = true,
                    onCheckedChange = {},
                    label = "Checked"
                )
            }
            item {
                HrCheckbox(
                    checked = false,
                    onCheckedChange = {},
                    label = "Unchecked"
                )
            }
            item {
                HrCheckbox(
                    checked = false,
                    onCheckedChange = {},
                    label = "Disabled",
                    enabled = false
                )
            }
            item {
                Avatar(
                    displayText = "JD",
                    image = painterResource(R.drawable.img_candidate_avatar)
                )
            }
            item {
                Avatar(
                    displayText = "JD"
                )
            }
            item {
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
    }
}