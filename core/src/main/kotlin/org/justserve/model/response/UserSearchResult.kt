package org.justserve.model.response

import io.micronaut.serde.annotation.Serdeable
import org.justserve.model.Organization
import org.justserve.model.Role

/**
 * JustServe.Contracts.Responses.UserSearchResult
 */
@Serdeable
data class UserSearchResult @JvmOverloads constructor(
    var id: String? = null,
    var firstName: String? = null,
    var lastName: String? = null,
    var userName: String? = null,
    var language: String? = null,
    var address: String? = null,
    var neighborhood: String? = null,
    var city: String? = null,
    var state: String? = null,
    var postal: String? = null,
    var country: String? = null,
    var countryCode: String? = null,
    var isActive: Boolean,
    var skills: List<String>? = null,
    var interests: List<String>? = null,
    var tools: List<String>? = null,
    var email: String? = null,
    var phone: String? = null,
    var keywords: String? = null,
    var adminRole: Role? = null,
    var organizations: List<Organization>? = null,
    var permissions: List<String>? = null,
    var assignedAreas: List<String>? = null,
    var churchBoundaries: List<String>? = null,
    var civicBoundaries: List<String>? = null,
    var manageableAdmin: Boolean,
    var showsSensitiveInfo: Boolean,
    var distance: Int,
    var relativityScore: Double,
    var volunteerProjects: List<ProjectSlim>? = null
) {}
