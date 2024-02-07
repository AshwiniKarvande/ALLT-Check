package org.pravin.alltcheck.feature.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import org.pravin.alltcheck.model.MedicalTest

@Composable
fun HomeRoute(
    navController: NavController,
    askNotificationPermission: Boolean,
    navigateToMedicationDetail: (MedicalTest) -> Unit,
    modifier: Modifier = Modifier,
) {
}


sealed class MedicalTestListItem {
    data class OverviewItem(val medicationsToday: List<MedicalTest>, val isMedicationListEmpty: Boolean) : MedicalTestListItem()
    data class MedicalTestItem(val medication: MedicalTest) : MedicalTestListItem()
    data class HeaderItem(val headerText: String) : MedicalTestListItem()
}