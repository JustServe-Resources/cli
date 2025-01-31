package org.justserve.model

import io.micronaut.serde.annotation.Serdeable

/**
 * JustServe.Contracts.ProjectOwner
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
@Serdeable
data class ProjectOwner(
    val id: String? = null
)