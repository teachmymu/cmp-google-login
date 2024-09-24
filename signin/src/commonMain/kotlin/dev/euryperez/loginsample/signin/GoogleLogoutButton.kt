package dev.euryperez.loginsample.signin


import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
expect fun GoogleLogoutButton(
    onLogout: () -> Unit,
    modifier: Modifier = Modifier
)
