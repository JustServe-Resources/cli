@file:Suppress("unused")
package org.justserve.model

import io.micronaut.serde.annotation.Serdeable

/**
 * JustServe.model.RecurringType
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
@Serdeable
enum class RecurringType(val value: Int) {
    None(0),
    Weekly(1),
    Monthly(2),
    DayOfMonth(3)
}
