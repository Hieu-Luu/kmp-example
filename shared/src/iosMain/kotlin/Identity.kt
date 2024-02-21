//import kotlinx.cinterop.ExperimentalForeignApi
//import kotlinx.cinterop.toKString
//import platform.posix.getlogin
//import platform.posix.getpid
//
//@OptIn(ExperimentalForeignApi::class)
//actual fun buildIdentity() = Identity(
//    getlogin()?.toKString() ?: "None",
//    getpid().toLong()
//)
//
//@OptIn(ExperimentalForeignApi::class)
//class IOSIdentity (
//    override val userName: String = getlogin()?.toKString() ?: "None",
//    override val processID: Long = getpid().toLong()
//) : IIdentity
//
//actual fun buildIIdentity(): IIdentity = IOSIdentity()
//
////actual properties
//actual val identity: IIdentity = IOSIdentity()
//
////actual objects
//actual object IdentityBuilder {
//    @OptIn(ExperimentalForeignApi::class)
//    actual fun build() = Identity(
//        getlogin()?.toKString() ?: "None",
//        getpid().toLong()
//    )
//}
//
////Inheritance from platform classes
//actual class CommonIdentity {
//    @OptIn(ExperimentalForeignApi::class)
//    actual val userName= getlogin()?.toKString() ?: "None"
//    actual val processID = getpid().toLong()
//}
//
////Additional enumeration entries on actualization
//actual enum class Department { IT, HR, Sales, Marketing }