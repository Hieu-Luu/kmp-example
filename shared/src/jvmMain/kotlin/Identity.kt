//actual fun buildIdentity() = Identity(
//    System.getProperty("user.name") ?: "None",
//    ProcessHandle.current().pid()
//)
//
//class JVMIdentity(
//    override val userName: String = System.getProperty("user.name") ?: "None",
//    override val processID: Long = ProcessHandle.current().pid()
//) : IIdentity
//
//actual fun buildIIdentity(): IIdentity = JVMIdentity()
//
////actual properties
//actual val identity: IIdentity = JVMIdentity()
//
////actual objects
//actual object IdentityBuilder {
//    actual fun build() = Identity(
//        System.getProperty("user.name") ?: "None",
//        ProcessHandle.current().pid()
//    )
//}
//
////Inheritance from platform classes
//open class OldIdentity {
//    val login: String = System.getProperty("user.name") ?: "none"
//    val pid: Long = ProcessHandle.current().pid()
//}
//
//actual class CommonIdentity : OldIdentity() {
//    actual val userName = login
//    actual val processID = pid
//}
//
////Application in frameworks
//actual abstract class AbsCommonIdentity : OldIdentity() {
//    actual val userName = login
//    actual val processID = pid
//    actual abstract val displayName: String
//}
//
////Using type aliases with existing type
//actual typealias Month = java.time.Month
//actual typealias MyDate = java.time.LocalDate
//
////Expanded visibility in actual declarations
//@Suppress("ACTUAL_WITHOUT_EXPECT")
//public actual typealias Messenger = MyMessenger
//class MyMessenger
//
////Additional enumeration entries on actualization
//actual enum class Department { IT, HR, Sales, Legal }
//
////Expected annotation classes
////actual typealias XmlSerializable = XmlRootElement