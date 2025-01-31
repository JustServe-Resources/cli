@file:Suppress("unused")
package org.justserve.model

import io.micronaut.serde.annotation.Serdeable

/**
 * JustServe.model.TimeOfDay
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
@Serdeable
enum class TimeOfDay(val value: Int) {
    None(0),
    Morning(1),
    Afternoon(2),
    Evening(3)
}
