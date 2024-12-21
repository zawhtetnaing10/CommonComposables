package com.zg.commoncomposables.ui.composables.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.zg.commoncomposables.ui.theme.CommonComposablesTheme
import kotlinx.serialization.Serializable

@Composable
fun NavigationDemo(navController: NavHostController = rememberNavController(), modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = NavRoutes.Home,
        modifier = modifier,
    ) {
        // Home
        composable<NavRoutes.Home> {
            HomeScreen(onClickDetails = {
                navController.navigate(NavRoutes.Details(it))
            })
        }

        // Details
        composable<NavRoutes.Details> { backStackEntry ->
            val args = backStackEntry.toRoute<NavRoutes.Details>()
            val message = args.message
            DetailsScreen(message,
                onTapBack = {
                    navController.navigateUp()
                },
                onNavigateToSettings = { messageFromDetails ->
                    navController.navigate(NavRoutes.Settings(messageFromDetails)){
                        val previousDestinationRoute = navController.previousBackStackEntry?.destination?.route
                        // inclusive = false, pop details but not home
                        previousDestinationRoute?.let {
                            popUpTo(it){inclusive = false}
                        }
                    }
                })
        }

        // Settings
        composable<NavRoutes.Settings> {  backStackEntry ->
            val args = backStackEntry.toRoute<NavRoutes.Settings>()
            val message = args.messageToSettings

            SettingsScreen(message = message, onTapBack = {
                // If there's nothing in the backstack, navigateUp will relaunch the start destination
                navController.navigateUp()
            }, onTapBackToHome = {
                navController.navigate(NavRoutes.Home){
                    // Navigate back until start destination which is Home and pop it also
                    // There will be nothing in the back stack. Then navigate to Home.
                    // This is the same as pushAndRemoveUntil.
                    popUpTo(navController.graph.startDestinationId) {inclusive = true}
                }
            })
        }
    }
}

// Navigation Routes
// Must be serializable
@Serializable
sealed class NavRoutes {
    @Serializable
    object Home

    @Serializable
    data class Details(val message: String)

    @Serializable
    data class Settings(val messageToSettings: String)
}

@Preview
@Composable
private fun NavigationDemoPreview() {
    CommonComposablesTheme {
        NavigationDemo()
    }
}