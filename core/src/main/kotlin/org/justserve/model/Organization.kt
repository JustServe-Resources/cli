package org.justserve.model

import io.micronaut.serde.annotation.Serdeable
import org.justserve.model.response.ProjectSlim

@Serdeable
data class Organization @JvmOverloads constructor(
    val id: String? = null,
    val language: String? = null,
    val organizationType: OrganizationType? = null,
    val endorsements: List<Endorsement>? = null,
    val owners: List<String>? = null,
    val representatives: List<OrgRepresentative>? = null,
    val name: String? = null,
    val description: String? = null,
    val status: OrganizationStatus? = null,
    val activationDate: String? = null,
    val firstStartTime: String? = null,
    val finalEndTime: String? = null,
    val website: String? = null,
    val autoRedirect: Boolean? = null,
    val url: String? = null,
    val internalURL: String? = null,
    val location: Location? = null,
    val logo: String? = null,
    val banner: String? = null,
    val facebookPath: String? = null,
    val googlePath: String? = null,
    val twitterPath: String? = null,
    val youTubePath: String? = null,
    val instagramPath: String? = null,
    val linkedInPath: String? = null,
    val contactName: String? = null,
    val contactPhone: String? = null,
    val contactEmail: String? = null,
    val linkedProjects: List<String>? = null,
    val created: String? = null,
    val updated: String? = null,
    val createdBy: String? = null,
    val updatedBy: String? = null,
    val deleted: Boolean? = null,
    val deletedOn: String? = null,
    val deletedBy: String? = null,
    val aboutUs: String? = null,
    val volunteerCenterInfo: VolunteerCenterInfo? = null,
    val projectsData: List<ProjectSlim>? = null,
    val totalProjectCount: Int? = null,
    val userCanEndorse: Boolean? = null,
    val relativityScore: Double? = null,
    val volunteerCenterParents: List<OrganizationSlim>? = null
)

