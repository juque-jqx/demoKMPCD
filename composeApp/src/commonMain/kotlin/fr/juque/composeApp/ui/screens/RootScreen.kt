package fr.juque.composeApp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import fr.juque.composeApp.data.DemosCompose
import fr.juque.composeApp.ui.components.DemoComposeButton
import fr.juque.composeApp.ui.theme.KMPCDTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun RootScreen(
    onDemoClicked: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        itemsIndexed(DemosCompose.entries) { _: Int, demo ->
            DemoComposeButton(
                labelResource = demo.screen.title,
                onClick = {
                    onDemoClicked(demo.screen.name)
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
