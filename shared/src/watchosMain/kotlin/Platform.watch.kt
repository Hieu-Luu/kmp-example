
class WatchOSPlatform: Platform {
    override val name: String = "WatchOS"
}

actual fun getPlatform(): Platform = WatchOSPlatform()