class JSPlatform: Platform {
    override val name: String = "JS Platform"
}

actual fun getPlatform(): Platform = JSPlatform()