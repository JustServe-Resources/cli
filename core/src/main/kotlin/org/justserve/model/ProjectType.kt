@file:Suppress("unused")
package org.justserve.model

import io.micronaut.serde.annotation.Serdeable

/**
 * JustServe.Contracts.ProjectType
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
@Serdeable
enum class ProjectType(val value: Int) {
    None(0),
    DTL(1),
    Ongoing(2),
    Recurring(3),
    MultipleDTL(4)
}