package org.pravin.alltcheck.feature.history

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import org.pravin.alltcheck.model.MedicalTest
import org.pravin.alltcheck.navigation.NavigationDestination

object HistoryDestination : NavigationDestination {
    override val route = "history_route"
    override val destination = "history_destination"
}

fun NavGraphBuilder.historyGraph(
    bottomBarVisibility: MutableState<Boolean>,
    fabVisibility: MutableState<Boolean>,
    navigateToMedicalTestDetail: (MedicalTest) -> Unit
) {
    composable(route = HistoryDestination.route) {
        LaunchedEffect(null) {
            bottomBarVisibility.value = true
            fabVisibility.value = false
        }
        HistoryRoute(navigateToMedicalTestDetail)
    }
}
