package org.justserve.model.response

import org.justserve.model.OrganizationStatus
import org.justserve.model.OrganizationType

import io.micronaut.serde.annotation.Serdeable

/**
 * JustServe.Contracts.Response.OrganizationSlim
 *
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
@Serdeable
data class OrganizationSlim(
    val id: String?,
    val organizationType: OrganizationType,
    val title: String?,
    val logo: String?,
    val url: String?,
    val internalURL: String?,
    val website: String?,
    val description: String?,
    val contactName: String?,
    val contactPhone: String?,
    val contactEmail: String?,
    val isIndividualProject: Boolean,
    val status: OrganizationStatus
)
