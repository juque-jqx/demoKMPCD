package fr.juque.composeApp.data

import fr.juque.composeApp.ui.screens.AppScreen

sealed class DemosCompose {
    data class Text(
        val screen: AppScreen = AppScreen.DemoComposeText,
    ) : DemosCompose()

    companion object {
        val entries = listOf(
            Text(),
        )
    }
}