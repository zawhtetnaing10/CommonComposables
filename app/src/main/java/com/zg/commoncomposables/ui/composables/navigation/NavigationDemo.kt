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
    ){
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
            DetailsScreen(message, onTapBack = {
                navController.navigateUp()
            })
        }
    }
}

// Navigation Routes
@Serializable
sealed class NavRoutes {
    @Serializable
    object Home

    @Serializable
    data class Details(val message : String)
}

@Preview
@Composable
private fun NavigationDemoPreview() {
    CommonComposablesTheme {
        NavigationDemo()
    }
}