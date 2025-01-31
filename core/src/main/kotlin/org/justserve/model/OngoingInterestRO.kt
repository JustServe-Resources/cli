package org.justserve.model

/**
 * JustServe.Contracts.OngoingInterestRO
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
data class OngoingInterestRO(
    var userId: String?,
    var interestedId: String?,
    var volunteerId: String?,
    var interestedLanguage: String?,
    var name: String?,
    var email: String?,
    var phone: String?,
    var schedule: String?,
    var date: String?,
    var groupSize: Int?,
    var hoursServed: List<OngoingHoursServed>?,
    var adminReportedHours: Double?,
    var interestedOn: String?
)
