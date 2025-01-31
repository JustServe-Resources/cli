package org.justserve.model

/**
 * JustServe.Contracts.OrganizationStatus
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
enum class OrganizationStatus(val value: Int) {
    None(0),
    Active(1),
    Pending(2),
    Inactive(3)
}