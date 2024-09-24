package dev.euryperez.loginsample

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import dev.euryperez.loginsample.utils.compositionlocals.LocalResources
import dev.euryperez.loginsample.signin.GoogleButton
import dev.euryperez.loginsample.signin.GoogleLogoutButton
import dev.euryperez.loginsample.signin.models.AuthResponse
import dev.euryperez.loginsample.utils.ImageFromUrl
import dev.euryperez.loginsample.utils.ResourcesImpl
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    CompositionLocalProvider(LocalResources provides ResourcesImpl()) {
        MaterialTheme {
            Column(
                modifier = Modifier.fillMaxSize().background(Color.White),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                var userName: String by remember { mutableStateOf("") }
                var imageUrl: String by remember { mutableStateOf("") }

                if (userName.isEmpty()) {
                    GoogleButton(
                        onResponse = {
                            println("Response: $it")
                            (it as? AuthResponse.Success)?.account?.profile?.let { profile ->
                                userName = profile.name
                                imageUrl = profile.picture ?: ""
                            }
                        }
                    )
                }else{
                    GoogleLogoutButton(
                        onLogout = {
                            userName = ""  // Clear the username when the user logs out
                        }
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))

                if (userName.isNotEmpty()) {
                    Text("Welcome $userName")
                    Spacer(modifier = Modifier.height(20.dp))
                    ImageFromUrl(
                        url = imageUrl,
                        modifier = Modifier
                    )


                }

            }
        }
    }
}
