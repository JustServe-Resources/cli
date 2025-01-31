package org.justserve.model.response

/**
 * JustServe.Contracts.Response.AttachmentInfo
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
data class AttachmentInfo(
    val id: String?,
    val mimeType: String?,
    val fileName: String?,
    val hostedFileLocation: String?
)
