package fr.juque.composeApp.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.stack.SnapshotStateStack
import demokmpcd.composeapp.generated.resources.Res
import demokmpcd.composeapp.generated.resources.app_name
import demokmpcd.composeapp.generated.resources.back_button
import fr.juque.composeApp.ui.screens.AppScreen
import org.jetbrains.compose.resources.stringResource

/**
 * Composable that displays the topBar and displays back button if back navigation is possible.
 */
@Composable
fun BackBar(
    currentScreen: AppScreen?,
    stack: SnapshotStateStack<AppScreen>,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(stringResource(currentScreen?.title?:Res.string.app_name)) },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier,
        navigationIcon = {
            IconButton(onClick = { stack.pop() }, enabled = stack.canPop) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = stringResource(Res.string.back_button)
                )
            }
        }
    )
}