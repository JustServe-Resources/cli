package org.justserve.model

import io.micronaut.serde.annotation.Serdeable

/**
 * JustServe.Contracts.ProjectOwnerLog
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
@Serdeable
data class ProjectOwnerLog(
    val projectId: String,
    val ownerUserId: String,
    val ownerUserFirstName: String?,
    val ownerUserLastName: String?,
    val updated: String?,
    val updatedBy: String?
)
