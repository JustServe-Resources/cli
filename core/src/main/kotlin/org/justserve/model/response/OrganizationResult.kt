package org.justserve.model.response

import io.micronaut.serde.annotation.Serdeable
import org.justserve.model.Location

@Serdeable
data class OrganizationResult @JvmOverloads constructor(
    val id: String? = null,
    val organizationOwners: List<UserSlim>? = null,
    val organizationType: String? = null,
    val language: String? = null,
    val name: String? = null,
    val description: String? = null,
    val website: String? = null,
    val url: String? = null,
    val location: Location,
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
    val linkedProjects: List<ProjectSlim>? = null,
    val projectsOwned: Int,
    val endorsedOrgsCount: Int,
    val orgIds: List<String>? = null,
    val associatedProjectIds: List<String>? = null,
    val created: String,
    val updated: String,
    val createdBy: String? = null,
    val updatedBy: String? = null,
    val distanceScore: Double,
    val relativityScore: Double
)