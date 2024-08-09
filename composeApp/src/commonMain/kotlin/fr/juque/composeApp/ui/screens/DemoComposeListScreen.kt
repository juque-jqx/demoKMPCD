package fr.juque.composeApp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import demokmpcd.composeapp.generated.resources.Res
import demokmpcd.composeapp.generated.resources.grid
import demokmpcd.composeapp.generated.resources.list
import demokmpcd.composeapp.generated.resources.spinner
import fr.juque.composeApp.ui.components.DemoComposeButton
import org.jetbrains.compose.resources.StringResource

enum class ListDemo(val title: StringResource) {
    List(title = Res.string.list),
    Grid(title = Res.string.grid),
    Spinner(title = Res.string.spinner),
}


@Composable
fun DemoComposeListScreen(
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(items = ListDemo.entries) { demo ->
            DemoComposeButton(
                labelResource = demo.title,
                onClick = {
//                    onDemoClicked(demo.name)
                }
            )
        }
    }
}