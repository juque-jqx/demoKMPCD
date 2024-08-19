package fr.juque.composeApp

import androidx.compose.runtime.*
import fr.juque.composeApp.ui.screens.AppScreens
import fr.juque.composeApp.ui.theme.KMPCDTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    KMPCDTheme {
        AppScreens()
    }
}