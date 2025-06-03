package org.justserve.model.response

import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class UserSlim(
    val id: String? = null,
    val name: String? = null,
    @Deprecated("Use name instead")
    val lastName: String? = null,
    val email: String? = null
)
