package org.justserve.model

import io.micronaut.serde.annotation.Serdeable

/**
 * JustServe.model.TimeSlot
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
@Serdeable
data class TimeSlot (
    val id: String? = null,
    val start: String,
    val end: String,
    val startFormatted: String? = null,
    val endFormatted: String? = null,
    val timezone: String? = null,
    val shiftTitle: String? = null,
    val volunteersCapped: Boolean,
    val groupsCapped: Boolean,
    val groupLimit: Int,
    val existingVolunteers: Int,
    val totalVolunteersNeeded: Int,
    val eventCapReached: Boolean,
    val contacts: List<Contact>? = null,
    val volunteers: List<VolunteerRO>? = null
)
