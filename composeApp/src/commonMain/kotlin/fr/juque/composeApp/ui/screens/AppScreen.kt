package fr.juque.composeApp.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import demokmpcd.composeapp.generated.resources.Res
import demokmpcd.composeapp.generated.resources.app_name
import demokmpcd.composeapp.generated.resources.list
import demokmpcd.composeapp.generated.resources.text
import fr.juque.composeApp.ui.components.BackBar
import org.jetbrains.compose.resources.StringResource


/**
 * enum values that represent the screens in the app
 */
enum class AppScreen(val title: StringResource) {
    Start(title = Res.string.app_name),
    DemoComposeText(title = Res.string.text),
    DemoComposeList(title = Res.string.list),
}

@Composable
fun AppScreen(
    navController: NavHostController = rememberNavController()
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = AppScreen.valueOf(
        backStackEntry?.destination?.route ?: AppScreen.Start.name
    )

    Scaffold(
        topBar = {
            BackBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() }
            )
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = AppScreen.Start.name,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            composable(route = AppScreen.Start.name) {
                RootScreen(
                    onDemoClicked = { newRoute ->
                        print("click on :$newRoute")
                        navController.navigate(newRoute)
                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                )
            }

            composable(route = AppScreen.DemoComposeText.name) {
                DemoComposeTextScreen(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                )
            }

            composable(route = AppScreen.DemoComposeList.name) {
                DemoComposeListScreen(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                )
            }
        }
    }
}