package fr.juque.composeApp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import fr.juque.composeApp.ui.components.DemoComposeButton
import fr.juque.composeApp.ui.theme.KMPCDTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun RootScreen(
    onDemoClicked: (AppScreen) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(items = AppScreen.entries) { demoScreen ->
            DemoComposeButton(
                labelResource = demoScreen.title,
                onClick = {
                    onDemoClicked(demoScreen)
                }
            )
        }
    }
}


@Preview
@Composable
fun RootScreenPreview() {
    KMPCDTheme {
        RootScreen(
            onDemoClicked = {},
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        )
    }
}
