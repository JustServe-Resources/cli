package org.justserve.model

import io.micronaut.serde.annotation.Serdeable

/**
 * JustServe.Contracts.DTL
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
@Serdeable
data class DTL(
    val id: String,
    val timeSlots: List<TimeSlot>,
    val locationName: String,
    val locationLink: String,
    val location: Location,
    val specialDirections: String,
    val specialDirectionsLanguage: Map<String, String?>,
    val boundaries: List<RegionCivicGeography>
)
