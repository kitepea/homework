package Homework.Lesson2_3

import Homework.Lesson2_3.StringOperationDelegates.trimmed
import Homework.Lesson2_3.StringOperationDelegates.uppercase

import java.util.*
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

object StringOperationDelegates {
    /**
     * Allows to store a string in uppercase
     */
    @JvmStatic
    fun uppercase(initial: String, locale: Locale = Locale.ROOT): ReadWriteProperty<Any?, String> =
        object : ReadWriteProperty<Any?, String> {
            // TODO: Implement the delegate
            private var uppercaseValue: String = initial

            // TODO: Implement the getValue
            override fun getValue(thisRef: Any?, property: KProperty<*>): String = uppercaseValue

            // TODO: Implement the setValue
            override fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
                uppercaseValue = value.uppercase(locale)
            }
        }

    /**
     * Allows to store a string without leading and trailing whitespaces
     */
    fun trimmed(initial: String): ReadWriteProperty<Any?, String> = object : ReadWriteProperty<Any?, String> {
        // TODO: Implement the delegate
        private var trimmedValue: String = initial

        // TODO: Implement the getValue
        override fun getValue(thisRef: Any?, property: KProperty<*>): String = trimmedValue

        // TODO: Implement the setValue
        override fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
            trimmedValue = value.trim()
        }
    }
}


class MyUser {
    var name: String by uppercase(initial = "rx-mobile-team")
    var bio: String by trimmed(initial = "Good")
}

fun main() {
    val user = MyUser()
    println("name is '${user.name}'")
    println("bio is '${user.bio}'")

    user.name = "RxMobileTeam"
    user.bio = "RxMobileTeam is a mobile full-stack development team.\n\n\n\n\n                 \n"

    println("After update:")
    println("name is '${user.name}'")
    println("bio is '${user.bio}'")
}