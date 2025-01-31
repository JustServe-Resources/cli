package org.justserve.model

import com.fasterxml.jackson.annotation.JsonFormat

import io.micronaut.serde.annotation.Serdeable

/**
 * JustServe.Contracts.Recurring
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
@Serdeable
data class Recurring(
    var recurrenceId: String?,
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    var start: String?,
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    var end: String?,
    var location: Location?,
    var locationName: String?,
    var specialDirections: String?,
    var recurringTimes: List<RecurringTime>?,
    var boundaries: List<RegionCivicGeography>?,
    var volunteeredRecurrences: List<VolunteeredRecurrence>?
)
