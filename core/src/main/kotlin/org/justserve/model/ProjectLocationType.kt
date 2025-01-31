@file:Suppress("unused")
package org.justserve.model

import io.micronaut.serde.annotation.Serdeable

/**
 * JustServe.Contracts.Enums.ProjectLocationType
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
@Serdeable
enum class ProjectLocationType(val value: Int) {
    None(0),
    SingleLocation(1),
    Regional(2),
    Remote(3)
}
