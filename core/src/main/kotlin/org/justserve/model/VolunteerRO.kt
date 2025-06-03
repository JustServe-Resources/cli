package org.justserve.model

import io.micronaut.serde.annotation.Serdeable

/**
 * JustServe.model.VolunteerRO
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
@Serdeable
data class VolunteerRO @JvmOverloads constructor(
    val userId: String? = null,
    val volunteerId: String? = null,
    val volunteerLanguage: String? = null,
    val name: String? = null,
    val email: String? = null,
    val phone: String? = null,
    val groupSize: Int? = null,
    val hoursServed: Double? = null,
    val adminReportedHours: Double? = null,
    val hoursUpdated: Boolean? = null,
    val skills: List<String>? = null,
    val volunteeredOn: String? = null
)