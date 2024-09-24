package dev.euryperez.loginsample.signin

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.interop.LocalUIViewController
import cocoapods.GoogleSignIn.GIDSignIn
import kotlinx.cinterop.ExperimentalForeignApi

@OptIn(ExperimentalForeignApi::class)
@Composable
actual fun GoogleLogoutButton(
    onLogout: () -> Unit,
    modifier: Modifier
) {
    GoogleLogoutButton(
        modifier = modifier,
        onLogout = {
            GIDSignIn.sharedInstance.signOut()
            onLogout()
        }
    )
}
