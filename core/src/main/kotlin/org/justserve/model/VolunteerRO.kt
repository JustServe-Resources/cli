package org.justserve.model

import io.micronaut.serde.annotation.Serdeable

/**
 * JustServe.model.VolunteerRO
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
@Serdeable
data class VolunteerRO(
    val userId: String?,
    val volunteerId: String?,
    val volunteerLanguage: String?,
    val name: String?,
    val email: String?,
    val phone: String?,
    val groupSize: Int?,
    val hoursServed: Double?,
    val adminReportedHours: Double?,
    val hoursUpdated: Boolean?,
    val skills: List<String>?,
    val volunteeredOn: String?
)