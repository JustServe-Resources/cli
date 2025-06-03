package org.justserve.model

import io.micronaut.serde.annotation.Serdeable

@Serdeable
enum class EndorsementStatus {
    Approved,
    RequestedByOrg,
    RequestedByVolunteerCenter,
    Rejected,
    Deleted
}

