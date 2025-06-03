package org.justserve.model

import io.micronaut.serde.annotation.Serdeable
import java.time.OffsetDateTime

@Serdeable
data class Endorsement(
    val organizationId: String? = null,
    val updated: OffsetDateTime,
    val endorsementStatus: EndorsementStatus
)

