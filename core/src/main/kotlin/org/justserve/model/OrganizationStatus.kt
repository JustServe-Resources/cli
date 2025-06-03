package org.justserve.model

import io.micronaut.serde.annotation.Serdeable

/**
 * JustServe.Contracts.OrganizationStatus
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
@Serdeable
enum class OrganizationStatus(val value: Int) {
    None(0),
    Active(1),
    Pending(2),
    Inactive(3)
}