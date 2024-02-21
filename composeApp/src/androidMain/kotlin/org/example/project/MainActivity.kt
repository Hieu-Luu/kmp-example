package org.example.project

import App
import Home
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.SpaceXSDK
import com.example.cache.DatabaseDriverFactory

class MainActivity : ComponentActivity() {
    private val sdk = SpaceXSDK(DatabaseDriverFactory(this))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
//            App()
            Home(sdk)
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App()
}