//class Identity (val userName: String, val processID: Long)
//
//expect fun buildIdentity(): Identity
//
////Interfaces with expected and actual functions
//interface IIdentity {
//    val userName: String
//    val processID: Long
//}
//
//expect fun buildIIdentity(): IIdentity
//
////Expected properties
//expect val identity: IIdentity
//
////Expected objects
//expect object IdentityBuilder {
//    fun build(): Identity
//}
//
////Inheritance from platform classes
//expect class CommonIdentity {
//    val userName: String
//    val processID: Long
//}
//
////Application in frameworks
//expect abstract class AbsCommonIdentity() {
//    val userName: String
//    val processID: Long
//    abstract val displayName: String
//}
//class MyCommonIdentity : AbsCommonIdentity() {
//    override val displayName = "Admin"
//}
//
////Using type aliases with existing type
//expect enum class Month {
//    JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY,
//    AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER
//}
//
//expect class MyDate {
//    fun getYear(): Int
//    fun getMonth(): Month
//    fun getDayOfMonth(): Int
//}
//
////Expanded visibility in actual declarations
//internal expect class Messenger {
//    fun sendMessage(message: String)
//}
//
////Additional enumeration entries on actualization
//expect enum class Department { IT, HR, Sales }
//
////Expected annotation classes
//@OptIn(ExperimentalMultiplatform::class)
//@Target(AnnotationTarget.CLASS)
//@Retention(AnnotationRetention.RUNTIME)
//@OptionalExpectation
//expect annotation class XmlSerializable()
//
//@XmlSerializable
//class Person(val name: String, val age: Int)