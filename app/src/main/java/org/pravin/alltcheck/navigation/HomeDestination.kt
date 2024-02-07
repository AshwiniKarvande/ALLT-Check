package org.pravin.alltcheck.navigation


import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import org.pravin.alltcheck.feature.home.HomeRoute
import org.pravin.alltcheck.model.MedicalTest

const val ASK_NOTIFICATION_PERMISSION = "notification_permission"
object HomeDestination : NavigationDestination {
    override val route = "home_route"
    override val destination = "home_destination"
}

fun NavGraphBuilder.homeGraph(navController: NavController, bottomBarVisibility: MutableState<Boolean>, fabVisibility: MutableState<Boolean>, navigateToMedicationDetail: (MedicalTest) -> Unit) {
    composable(route = HomeDestination.route) {
        LaunchedEffect(null) {
            bottomBarVisibility.value = true
            fabVisibility.value = true
        }
        val askNotificationPermission = navController.currentBackStackEntry?.savedStateHandle?.get<Boolean>(ASK_NOTIFICATION_PERMISSION) ?: false
        HomeRoute(navController, askNotificationPermission, navigateToMedicationDetail)
    }
}
