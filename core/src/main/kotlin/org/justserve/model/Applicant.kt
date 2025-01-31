package org.justserve.model

import com.fasterxml.jackson.annotation.JsonFormat

/**
 * JustServe.Contracts.Applicant
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
data class Applicant(
    var submitterUserId: String?,
    var firstName: String?,
    var lastName: String?,
    var email: String?,
    var phone: String?,
    var postal: String?,
    var applicantPostal: String?,
    var applicantCity: String?,
    var applicantCountry: String?,
    var applicantCountryCode: String?,
    var assignmentLevel: GeographyType?,
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    var assignedOn: String?
)