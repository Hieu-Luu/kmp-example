import androidx.compose.ui.window.ComposeUIViewController
import com.example.SpaceXSDK
import com.example.cache.DatabaseDriverFactory

private val sdk = SpaceXSDK(DatabaseDriverFactory())

fun MainViewController() = ComposeUIViewController {
//    App()
    Home(sdk)
}
