@file:Suppress("unused")
package org.justserve.model

/**
 * JustServe.Contracts.OrganizationType
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
enum class OrganizationType(val value: Int) {
    None(0),
    Organization(1),
    VolunteerCenter(2),
    DisasterRelief(3)
}