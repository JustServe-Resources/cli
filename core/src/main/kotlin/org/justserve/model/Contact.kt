package org.justserve.model

import io.micronaut.serde.annotation.Serdeable

/**
 * JustServe.Contracts.Contact
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
@Serdeable
data class Contact(
    var name: String?,
    var phone: String?,
    var email: String?
)
