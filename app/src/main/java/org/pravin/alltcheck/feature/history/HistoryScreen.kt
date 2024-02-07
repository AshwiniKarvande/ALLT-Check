package org.pravin.alltcheck.feature.history

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import org.pravin.alltcheck.feature.history.viewmodel.HistoryState
import org.pravin.alltcheck.feature.history.viewmodel.HistoryViewModel
import org.pravin.alltcheck.analytics.AnalyticsHelper
import org.pravin.alltcheck.R
import org.pravin.alltcheck.feature.home.MedicalTestListItem
import org.pravin.alltcheck.model.MedicalTest
import org.pravin.alltcheck.util.hasPassed

@Composable
fun HistoryRoute(
    navigateToMedicationDetail: (MedicalTest) -> Unit,
    viewModel: HistoryViewModel = hiltViewModel()
) {
    val analyticsHelper = AnalyticsHelper.getInstance(LocalContext.current)
    val state = viewModel.state
    HistoryScreen(analyticsHelper, state, navigateToMedicationDetail)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HistoryScreen(analyticsHelper: AnalyticsHelper, state: HistoryState, navigateToMedicationDetail: (MedicalTest) -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier
                    .padding(top = 16.dp),
                title = {
                    Text(
                        text = stringResource(id = R.string.history),
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.displaySmall,
                    )
                }
            )
        },
        bottomBar = { },
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            MedicationList(analyticsHelper, state, navigateToMedicationDetail)
        }
    }
}

@Composable
fun MedicationList(analyticsHelper: AnalyticsHelper, state: HistoryState, navigateToMedicationDetail: (MedicalTest) -> Unit) {

    val filteredMedicationList = state.medicalTests.filter { it.sampleTime.hasPassed() }
    val sortedMedicationList: List<MedicalTestListItem> = filteredMedicationList.sortedBy { it.sampleTime }.map { MedicalTestListItem.MedicalTestItem(it) }

    when (sortedMedicationList.isEmpty()) {
        true -> EmptyView()
        false -> MedicationLazyColumn(sortedMedicationList, navigateToMedicationDetail)
    }
}

@Composable
fun MedicationLazyColumn(sortedMedicationList: List<MedicalTestListItem>, navigateToMedicationDetail: (MedicalTest) -> Unit) {
    LazyColumn(
        modifier = Modifier,
        contentPadding = PaddingValues(vertical = 8.dp)
    ) {
        items(
            items = sortedMedicationList,
            itemContent = {
                when (it) {
                    is MedicalTestListItem.OverviewItem -> { }
                    is MedicalTestListItem.HeaderItem -> {
                        Text(
                            modifier = Modifier
                                .padding(4.dp, 12.dp, 8.dp, 0.dp)
                                .fillMaxWidth(),
                            text = it.headerText.uppercase(),
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.titleMedium,
                        )
                    }
                    is MedicalTestListItem.MedicalTestItem -> {

                    }
                }
            }
        )
    }
}

@Composable
fun EmptyView() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.padding(16.dp),
            style = MaterialTheme.typography.headlineMedium,
            text = stringResource(id = R.string.no_history_yet),
            color = MaterialTheme.colorScheme.tertiary
        )
    }
}
