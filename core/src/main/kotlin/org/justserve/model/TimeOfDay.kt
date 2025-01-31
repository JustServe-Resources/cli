@file:Suppress("unused")
package org.justserve.model

/**
 * JustServe.model.TimeOfDay
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
enum class TimeOfDay(val value: Int) {
    None(0),
    Morning(1),
    Afternoon(2),
    Evening(3)
}
