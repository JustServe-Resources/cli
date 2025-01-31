package org.justserve.model

import com.fasterxml.jackson.annotation.JsonFormat

import io.micronaut.serde.annotation.Serdeable

/**
 * JustServe.Contracts.OngoingHoursServed
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
@Serdeable
data class OngoingHoursServed(
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    val servedOn: String,
    val hoursServed: Double)