package fr.juque.composeApp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun DemoComposeTextScreen(
    modifier: Modifier = Modifier
) {
    Column(

    ) {
        Text(
            text = "tototototot",//stringResource(demo.title),
            modifier = Modifier
        )
    }
}