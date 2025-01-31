package org.justserve.model

/**
 * JustServe.Contracts.OnGoing
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
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
