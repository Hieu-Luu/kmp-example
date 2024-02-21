import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.example.SpaceXSDK
import com.example.cache.DatabaseDriverFactory

private val sdk = SpaceXSDK(DatabaseDriverFactory())

fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = "AllPlatformTemplate") {
//        App()
        Home(sdk)
    }
}

@Preview
@Composable
fun AppDesktopPreview() {
    App()
}