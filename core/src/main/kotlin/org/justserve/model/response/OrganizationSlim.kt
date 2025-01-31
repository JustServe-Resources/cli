package org.justserve.model.response

import org.justserve.model.OrganizationStatus
import org.justserve.model.OrganizationType

/**
 * JustServe.Contracts.Response.OrganizationSlim
 *
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
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
