package org.justserve.model

import com.fasterxml.jackson.annotation.JsonFormat

/**
 * JustServe.Contracts.OngoingHoursServed
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
data class OngoingHoursServed(
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    val servedOn: String,
    val hoursServed: Double)