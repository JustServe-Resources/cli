package org.justserve.model

/**
 * JustServe.Contracts.Response.OrganizationSlim
 *
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
data class OrganizationSlim @JvmOverloads constructor(
    var id: String? = null,
    var organizationType: OrganizationType,
    var title: String? = null,
    var logo: String? = null,
    var url: String? = null,
    var internalURL: String? = null,
    var website: String? = null,
    var description: String? = null,
    var contactName: String? = null,
    var contactPhone: String? = null,
    var contactEmail: String? = null,
    var isIndividualProject: Boolean,
    var status: OrganizationStatus? = null,
){}