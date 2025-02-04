package org.justserve.model.response

import io.micronaut.serde.annotation.Serdeable
import org.justserve.model.Project

@Serdeable
data class AdminPendingProjectsResponse (
    val pageNumber: Int,
    val pageSize: Int,
    val projects: List<Project>,
    val itemCount: Int
)