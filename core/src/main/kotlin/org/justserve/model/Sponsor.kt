package org.justserve.model

import io.micronaut.serde.annotation.Serdeable

/**
 * JustServe.model.Sponsor
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
@Serdeable
data class Sponsor(
    var name: String?,
    var email: String?,
    var phone: String?,
    var userId: String?
)
