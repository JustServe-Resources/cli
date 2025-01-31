package org.justserve.model

import io.micronaut.serde.annotation.Serdeable

/**
 * JustServe.Contracts.RecurringTime
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
@Serdeable
data class RecurringTime(
    val id: String?,
    val startTime: String,
    val endTime: String,
    val recurringType: RecurringType,
    val volunteersCapped: Boolean,
    val groupsCapped: Boolean,
    val groupLimit: Int,
    val totalVolunteersNeeded: Int,
    val contacts: List<Contact>?,
    val sunday: Boolean,
    val monday: Boolean,
    val tuesday: Boolean,
    val wednesday: Boolean,
    val thursday: Boolean,
    val friday: Boolean,
    val saturday: Boolean,
    val firstWeek: Boolean,
    val secondWeek: Boolean,
    val thirdWeek: Boolean,
    val fourthWeek: Boolean,
    val fifthWeek: Boolean,
    val lastWeek: Boolean,
    val daysOfMonth: List<Int>?
)
