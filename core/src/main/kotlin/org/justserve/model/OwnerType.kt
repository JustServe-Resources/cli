package org.justserve.model

import io.micronaut.serde.annotation.Serdeable

/**
 * JustServe.model.OwnerType
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
@Serdeable
enum class OwnerType(val value: Int) {
    USER(1),
    ORGANIZATION(2)
}