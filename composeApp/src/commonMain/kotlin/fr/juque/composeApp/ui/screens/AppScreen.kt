package fr.juque.composeApp.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.stack.rememberStateStack
import demokmpcd.composeapp.generated.resources.Res
import demokmpcd.composeapp.generated.resources.list
import demokmpcd.composeapp.generated.resources.text
import fr.juque.composeApp.ui.components.BackBar
import org.jetbrains.compose.resources.StringResource


/**
 * enum values that represent the screens in the app
 */
enum class AppScreen(val title: StringResource) {
    DemoComposeText(title = Res.string.text),
    DemoComposeList(title = Res.string.list),
}

@Composable
fun AppScreens() {
    val stateStack = rememberStateStack<AppScreen>()
    Scaffold(
        topBar = {
            BackBar(
                currentScreen = stateStack.lastItemOrNull,
                stack = stateStack,
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            if(stateStack.lastItemOrNull == null) {
                RootScreen(
                    onDemoClicked = { newRoute ->
                        print("click on :$newRoute")
                        stateStack.push(newRoute)
                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                )
            }

            if(stateStack.lastItemOrNull == AppScreen.DemoComposeText) {
                DemoComposeTextScreen(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                )
            }

            if(stateStack.lastItemOrNull == AppScreen.DemoComposeList) {
                DemoComposeListScreen(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                )
            }
        }
    }
}