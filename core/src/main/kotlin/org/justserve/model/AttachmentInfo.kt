package org.justserve.model

import io.micronaut.serde.annotation.Serdeable

/**
 * JustServe.Contracts.Response.AttachmentInfo
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
@Serdeable
data class AttachmentInfo(
    val id: String?,
    val mimeType: String?,
    val fileName: String?,
    val hostedFileLocation: String?
)