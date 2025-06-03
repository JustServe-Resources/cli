package org.justserve.model.response

import org.justserve.model.Location
import org.justserve.model.ProjectStatus

data class ProjectSlim @JvmOverloads constructor(
    var id: String? = null,
    var title: String? = null,
    var description: String? = null,
    var projectExpired: Boolean,
    var orgAuthorizationPending: Boolean? = null,
    var status: ProjectStatus? = null,
    var startDate: String? = null,
    var endDate: String? = null,
    var locations: List<Location>? = null,
    var lastChangeReason: String? = null,
    var needsAttention: Boolean? = null,
    var isActive: Boolean? = null,
    var isUnlistedProject: Boolean,
    var isDirectlyOwnedOrSponsored: Boolean,
    var isOwnedOrRepresentedViaOrganization: Boolean,
    var isIndividualProject: Boolean,
    var projectOwnerName: String? = null,
    var projectOwnerUserId: String? = null,
    var relativityScore: Double? = null,
){}