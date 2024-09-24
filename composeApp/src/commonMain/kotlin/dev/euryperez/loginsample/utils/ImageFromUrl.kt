package dev.euryperez.loginsample.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
expect fun ImageFromUrl(url: String, modifier: Modifier = Modifier)
