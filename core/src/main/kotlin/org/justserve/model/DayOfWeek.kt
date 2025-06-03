package org.justserve.model

import io.micronaut.serde.annotation.Serdeable

/**
 * JustServe.Contracts.DayOfWeek
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
@Serdeable
enum class DayOfWeek(val value: Int) {
    Sunday(0),
    Monday(1),
    Tuesday(2),
    Wednesday(3),
    Thursday(4),
    Friday(5),
    Saturday(6)
}