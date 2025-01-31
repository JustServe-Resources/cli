package org.justserve.model

import com.fasterxml.jackson.annotation.JsonFormat

import io.micronaut.serde.annotation.Serdeable

/**
 * JustServe.Contracts.Org
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
@Serdeable
data class Org(
    val authorization: Boolean,
    val organizationAuthorization: Boolean?,
    val name: String?,
    val description: String?,
    val url: String?,
    val internalUrl: String?,
    val organizationId: String?,
    val reviewedBy: String?,
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    val reviewedOn: String?,
    val linked: Boolean,
    val logo: String?
)
