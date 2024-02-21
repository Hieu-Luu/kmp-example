import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class Greeting {
    private val platform = getPlatform()

    fun greet(): String {
        return "Hello, ${platform.name}!"
    }

    fun useCoroutineInCommon() {
        val dispatcher: CoroutineDispatcher = Dispatchers.Main
    }
}