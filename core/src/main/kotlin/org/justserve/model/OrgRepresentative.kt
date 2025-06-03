package org.justserve.model
import io.micronaut.serde.annotation.Serdeable
import java.time.OffsetDateTime
import java.util.UUID

@Serdeable
data class OrgRepresentative @JvmOverloads constructor(
    val representativeUserId: UUID,
    val created: OffsetDateTime? = null,
    val createdBy: UUID,
    val updated: OffsetDateTime? = null,
    val updatedBy: UUID? = null
)

