package dev.euryperez.loginsample.utils
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.interop.UIKitView
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.coroutines.*
import platform.Foundation.*
import platform.UIKit.UIImage
import platform.UIKit.UIImageView
import platform.darwin.dispatch_get_main_queue
import platform.darwin.dispatch_async

@OptIn(ExperimentalForeignApi::class)
@Composable
actual fun ImageFromUrl(url: String, modifier: Modifier) {
    UIKitView(
        modifier = modifier,
        factory = {
            val imageView = UIImageView()

            val nsUrl = NSURL(string = url)

            GlobalScope.launch(Dispatchers.Main) {
                val data = NSData.dataWithContentsOfURL(nsUrl)
                if (data != null) {
                    val uiImage = UIImage(data = data)
                    dispatch_async(dispatch_get_main_queue()) {
                        imageView.image = uiImage
                    }
                } else {
                    // Handle the error case (image failed to load)
                    println("Failed to load image from URL: $url")
                }
            }
            imageView
        }
    )
}
