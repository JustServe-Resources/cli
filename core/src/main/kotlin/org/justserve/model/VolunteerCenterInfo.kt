package org.justserve.model

import io.micronaut.serde.annotation.Serdeable
import org.justserve.model.response.OrganizationResult

@Serdeable
data class VolunteerCenterInfo @JvmOverloads constructor(
    val id: String? = null,
    val associatedProjects: List<String>? = null,
    val defaultSection: DefaultSection? = null,
    val organizationsEnabled: Boolean? = null,
    val projectsEnabled: Boolean? = null,
    val questionsEnabled: Boolean? = null,
    val aboutUsEnabled: Boolean? = null,
    val giveEnabled: Boolean? = null,
    val about: String? = null,
    val endorsedOrganizationsData: List<OrganizationResult>? = null
)
