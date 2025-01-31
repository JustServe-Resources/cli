package org.justserve.model

import io.micronaut.serde.annotation.Serdeable

/**
 * JustServe.Contracts.OnGoing
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
@Serdeable
data class OnGoing (
    val id: String?,
    val start: String,
    val renewDate: String,
    val end: String,
    val schedule: String?,
    val scheduleLanguage: Map<String, String?>?,
    val specialDirections: String?,
    val specialDirectionsLanguage: Map<String, String?>?,
    val locationName: String?,
    val locationLink: String?,
    val location: Location,
    val interested: List<OngoingInterestRO>?,
    val contacts: List<Contact>?,
    val boundaries: List<RegionCivicGeography>?
)
