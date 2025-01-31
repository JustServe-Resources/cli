package org.justserve.model

import io.micronaut.serde.annotation.Serdeable

/**
 * JustServe.Contracts.Representative
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
@Serdeable
data class Representative(
    val name: String?,
    val email: String?,
    val userId: String?
)
