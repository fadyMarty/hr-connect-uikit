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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp
import com.hrconnect.storybook.R
import com.hrconnect.uikit.presentation.components.avatar.Avatar
import com.hrconnect.uikit.presentation.components.bottom_bar.BottomBar
import com.hrconnect.uikit.presentation.components.bottom_bar.BottomBarItem
import com.hrconnect.uikit.presentation.components.buttons.DestructiveButton
import com.hrconnect.uikit.presentation.components.buttons.PrimaryButton
import com.hrconnect.uikit.presentation.components.buttons.SecondaryButton
import com.hrconnect.uikit.presentation.components.cards.ListCard
import com.hrconnect.uikit.presentation.components.checkbox.HrCheckbox
import com.hrconnect.uikit.presentation.components.inputs.Input
import com.hrconnect.uikit.presentation.components.inputs.PasswordInput
import com.hrconnect.uikit.presentation.components.progress_bar.ProgressBar
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
                    label = AnnotatedString("Checked")
                )
            }
            item {
                HrCheckbox(
                    checked = false,
                    onCheckedChange = {},
                    label = AnnotatedString("Unchecked")
                )
            }
            item {
                HrCheckbox(
                    checked = false,
                    onCheckedChange = {},
                    label = AnnotatedString("Disabled"),
                    enabled = false
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
                BottomBar(
                    items = getBottomBarItems(Route.HrBoard),
                    onItemClick = {}
                )
            }
            item {
                BottomBar(
                    items = getBottomBarItems(Route.CandidateList),
                    onItemClick = {}
                )
            }
            item {
                BottomBar(
                    items = getBottomBarItems(Route.VacancyList),
                    onItemClick = {}
                )
            }
            item {
                ProgressBar(
                    currentPage = 0,
                    pageCount = 3
                )
            }
            item {
                ProgressBar(
                    currentPage = 1,
                    pageCount = 3
                )
            }
            item {
                ProgressBar(
                    currentPage = 2,
                    pageCount = 3
                )
            }
        }
    }
}

private sealed interface Route {
    data object HrBoard : Route
    data object CandidateList : Route
    data object VacancyList : Route
}

@Composable
private fun getBottomBarItems(
    selectedRoute: Route,
): List<BottomBarItem<Route>> {
    return listOf(
        BottomBarItem(
            selected = selectedRoute == Route.HrBoard,
            icon = ImageVector.vectorResource(R.drawable.ic_dashboard),
            label = "Board",
            route = Route.HrBoard
        ),
        BottomBarItem(
            selected = selectedRoute == Route.CandidateList,
            icon = ImageVector.vectorResource(R.drawable.ic_groups),
            label = "Candidates",
            route = Route.CandidateList
        ),
        BottomBarItem(
            selected = selectedRoute == Route.VacancyList,
            icon = ImageVector.vectorResource(R.drawable.ic_work),
            label = "Vacancies",
            route = Route.VacancyList
        )
    )
}