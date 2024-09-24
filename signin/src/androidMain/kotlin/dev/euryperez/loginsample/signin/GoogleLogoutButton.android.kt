package dev.euryperez.loginsample.signin

import android.app.Activity
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import dev.euryperez.loginsample.signin.models.AuthResponse

@Composable
actual fun GoogleLogoutButton(
    onLogout: () -> Unit,
    modifier: Modifier
){
    val activity = LocalContext.current as Activity
    val googleSignInClient = GoogleSignIn.getClient(activity, GoogleSignInOptions.DEFAULT_SIGN_IN)

    GoogleButtonUI(
        modifier = modifier,
        onClick = {
            googleSignInClient.signOut().addOnCompleteListener {
                onLogout() // Call the onLogout function when sign-out completes
            }},
        title = "Logout"
    )


//    Button(
//        modifier = modifier,
//        onClick = {
//            googleSignInClient.signOut().addOnCompleteListener {
//                onLogout() // Call the onLogout function when sign-out completes
//            }
//        }
//    ) {
//        Text(text = "Logout") // Text to display on the button
//    }
}

