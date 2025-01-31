package org.justserve.model

import com.fasterxml.jackson.annotation.JsonFormat

/**
 * JustServe.model.VolunteeredRecurrence
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
data class VolunteeredRecurrence(
    val volunteeredRecurrenceId: String? = null,
    val recurringTimeId: String? = null,
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    val start: String,
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    val end: String,
    val eventCapReached: Boolean,
    val volunteers: List<String>? = null
)
