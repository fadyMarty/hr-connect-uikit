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
import com.hrconnect.uikit.presentation.components.badge.StatusBadge
import com.hrconnect.uikit.presentation.components.badge.StatusType
import com.hrconnect.uikit.presentation.components.bottom_bar.BottomBar
import com.hrconnect.uikit.presentation.components.bottom_bar.BottomBarItem
import com.hrconnect.uikit.presentation.components.buttons.DestructiveButton
import com.hrconnect.uikit.presentation.components.buttons.PrimaryButton
import com.hrconnect.uikit.presentation.components.buttons.SecondaryButton
import com.hrconnect.uikit.presentation.components.cards.ListCard
import com.hrconnect.uikit.presentation.components.cards.ResultRow
import com.hrconnect.uikit.presentation.components.checkbox.HrCheckbox
import com.hrconnect.uikit.presentation.components.file_upload.FileUpload
import com.hrconnect.uikit.presentation.components.inputs.Input
import com.hrconnect.uikit.presentation.components.inputs.PasswordInput
import com.hrconnect.uikit.presentation.components.progress_bar.LinearProgressBar
import com.hrconnect.uikit.presentation.components.progress_bar.ProgressBar
import com.hrconnect.uikit.presentation.components.score_card.ScoreCard
import com.hrconnect.uikit.presentation.components.select.Select
import com.hrconnect.uikit.presentation.components.submission_card.SubmissionCard
import java.util.Date

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
            // ========== Существующие компоненты ==========
            item { PrimaryButton(label = "Primary Default", onClick = {}) }
            item { PrimaryButton(label = "Primary Disabled", onClick = {}, enabled = false) }
            item { SecondaryButton(label = "Secondary", onClick = {}) }
            item { DestructiveButton(label = "Destructive Solid", onClick = {}) }
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
                    items = listOf("Engineering", "Department 1", "Department 2", "Department 3"),
                    selectedItem = "Engineering",
                    onItemClick = {},
                    label = "Select Department"
                )
            }
            item {
                HrCheckbox(checked = true, onCheckedChange = {}, label = AnnotatedString("Checked"))
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
            item { Avatar(displayText = "JD") }
            item { BottomBar(items = getBottomBarItems(Route.HrBoard), onItemClick = {}) }
            item { BottomBar(items = getBottomBarItems(Route.CandidateList), onItemClick = {}) }
            item { BottomBar(items = getBottomBarItems(Route.VacancyList), onItemClick = {}) }
            item { ProgressBar(currentPage = 0, pageCount = 3) }
            item { ProgressBar(currentPage = 1, pageCount = 3) }
            item { ProgressBar(currentPage = 2, pageCount = 3) }

            // ========== НОВЫЕ КОМПОНЕНТЫ ==========
            // 1. StatusBadge
            item {
                androidx.compose.foundation.layout.Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    androidx.compose.foundation.layout.Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        StatusBadge(StatusType.PENDING)
                        StatusBadge(StatusType.RUNNING)
                    }
                    androidx.compose.foundation.layout.Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        StatusBadge(StatusType.PASSED)
                        StatusBadge(StatusType.FAILED)
                    }
                    StatusBadge(StatusType.ERROR)
                    StatusBadge(StatusType.RUNNING, label = "In Progress")
                }
            }

            // 2. LinearProgressBar
            item {
                androidx.compose.foundation.layout.Column(
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    LinearProgressBar(progress = 30, showLabel = true)   // красный
                    LinearProgressBar(progress = 65, showLabel = true)   // жёлтый
                    LinearProgressBar(progress = 90, showLabel = true)   // зелёный
                    LinearProgressBar(progress = 100, showLabel = true)  // 100%
                    LinearProgressBar(progress = 45, showLabel = false)  // без метки
                }
            }

            // 3. ScoreCard
            item {
                androidx.compose.foundation.layout.Column(
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    ScoreCard(
                        score = 92,
                        assignmentTitle = "Kotlin Multiplatform Mobile",
                        candidateName = "Алексей Иванов",
                        status = StatusType.PASSED,
                        onClick = {}
                    )
                    ScoreCard(
                        score = 67,
                        assignmentTitle = "Compose UI Implementation",
                        candidateName = "Мария Петрова",
                        status = StatusType.RUNNING
                    )
                    ScoreCard(
                        score = 34,
                        assignmentTitle = "Clean Architecture",
                        candidateName = "Дмитрий Смирнов",
                        status = StatusType.FAILED
                    )
                }
            }

            // 4. DataTable
//            item {
//                val sampleRows = listOf(
//                    Person("Alice", 25, "Engineer"),
//                    Person("Bob", 30, "Designer"),
//                    Person("Charlie", 28, "PM"),
//                    Person("Diana", 32, "QA")
//                )
//                val columns = listOf(
//                    ColumnConfig<Person>("Name") { it.name },
//                    ColumnConfig("Age") { it.age },
//                    ColumnConfig("Role") { it.role }
//                )
//                DataTable(
//                    rows = sampleRows,
//                    columns = columns,
//                    onRowClick = { person -> /* клик */ },
//                    rowsPerPage = 2
//                )
//            }

            // 5. FileUpload
            item {
                FileUpload(
                    onFileSelected = { result ->
                        println("File selected: ${result.fileName}")
                    }
                )
            }

            // 6. SubmissionCard
            item {
                androidx.compose.foundation.layout.Column(
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    SubmissionCard(
                        submissionDate = Date(),
                        assignmentTitle = "Разработка модуля авторизации",
                        status = StatusType.PASSED,
                        score = 94,
                        onClick = {}
                    )
                    SubmissionCard(
                        submissionDate = Date(System.currentTimeMillis() - 86400000),
                        assignmentTitle = "Дизайн архитектуры приложения",
                        status = StatusType.RUNNING,
                        score = null
                    )
                    SubmissionCard(
                        submissionDate = Date(System.currentTimeMillis() - 172800000),
                        assignmentTitle = "Реализация UI-компонентов",
                        status = StatusType.FAILED,
                        score = 34
                    )
                }
            }

            // 7. ResultRow
            item {
                androidx.compose.foundation.layout.Column {
                    ResultRow(
                        checkName = "Статический анализ кода",
                        status = StatusType.PASSED,
                        score = 95,
                        details = "Найдено 2 предупреждения о стиле кода. Ошибок нет."
                    )
                    ResultRow(
                        checkName = "Модульные тесты",
                        status = StatusType.RUNNING,
                        score = 72,
                        details = "Пройдено 18 из 25 тестов. Остальные выполняются."
                    )
                    ResultRow(
                        checkName = "Проверка безопасности",
                        status = StatusType.FAILED,
                        score = 32,
                        details = "Обнаружены уязвимости: SQL injection в модуле входа."
                    )
                    ResultRow(
                        checkName = "Без деталей",
                        status = StatusType.PENDING,
                        score = 0,
                        details = null
                    )
                }
            }
        }
    }
}

// Пример класса данных для DataTable
private data class Person(val name: String, val age: Int, val role: String)

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