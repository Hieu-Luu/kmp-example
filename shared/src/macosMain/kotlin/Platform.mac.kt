class MacOSPlatform: Platform {
    override val name: String = "WatchOS"
}

actual fun getPlatform(): Platform = MacOSPlatform()