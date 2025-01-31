package org.justserve.model

import com.fasterxml.jackson.annotation.JsonFormat
import org.justserve.model.response.AttachmentInfo
import org.justserve.model.response.OrganizationSlim

import io.micronaut.serde.annotation.Serdeable

/**
 * JustServe.Contracts.Project
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
@Serdeable
data class Project(
    var id: String?,
    var projectOwners: Array<ProjectOwner>?,
    var location: Location,
    var ownerLog: Array<ProjectOwnerLog>?,
    var projectType: ProjectType,
    var status: ProjectStatus,
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    var publishDate: String?,
    var language: String?,
    var country: String?,
    var title: String?,
    var shortDescription: String?,
    var longDescription: String?,
    var logo: String?,
    var attachments: Array<String>?,
    var attachmentInfo: Array<AttachmentInfo>?,
    var applicant: Applicant?,
    var contact: Contact?,
    var sponsor: Sponsor?,
    var representative: Representative?,
    var organization: Org?,
    var suitableAllAges: Boolean?,
    var groupProject: Boolean?,
    var volunteerRemotely: Boolean?,
    var itemDonations: Boolean?,
    var wheelchairAccessible: Boolean?,
    var indoors: Boolean?,
    var forYouthGroups: Boolean?,
    var volunteerFromAnywhere: Boolean?,
    var regionSelected: Boolean?,
    var temporaryFakeDistanceScore: Double?,
    var fakeDistanceScoreUpdate: String?,
    var skills: Array<String>?,
    var interests: Array<String>?,
    var tools: Array<String>?,
    var projectSkills: Array<Int>?,
    var projectInterests: Array<Int>?,
    var projectTools: Array<Int>?,
    var externalVolunteerURL: String?,
    var isExternalProject: Boolean?,
    var isUnlistedProject: Boolean?,
    var archivedProject: Boolean?,
    var isActive: Boolean?,
    var externalVolunteerCount: Int?,
    var externalVolunteers: Array<String>?,
    var allEventsFilled: Boolean?,
    var daysOfWeek: Array<DayOfWeek>?,
    var timesOfDay: Array<TimeOfDay>?,
    var waiverURL: String?,
    var dtl: Array<DTL>?,
    var onGoing: Array<OnGoing>?,
    var recurring: Recurring?,
    var lastChangeReason: String?,
    var escalated: String?,
    var created: String,
    var updated: String,
    var createdBy: String?,
    var deleted: Boolean,
    var deletedOn: String?,
    var deletedBy: String?,
    var firstStartDateTimeOffset: String?,
    var lastEndDateTimeOffset: String?,
    var cbfName: String?,
    var cblName: String?,
    var updatedBy: String?,
    var ubfName: String?,
    var ublName: String?,
    var volunteerCentersData: Array<OrganizationSlim>?,
    var relativityScore: Double?,
    var projectOwnerName: String?,
    var projectOwnerLastName: String?,
    var projectOwnerUserId: String?,
    var projectLocationType: ProjectLocationType?,
    var underReview: Boolean?,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Project

        if (suitableAllAges != other.suitableAllAges) return false
        if (groupProject != other.groupProject) return false
        if (volunteerRemotely != other.volunteerRemotely) return false
        if (itemDonations != other.itemDonations) return false
        if (wheelchairAccessible != other.wheelchairAccessible) return false
        if (indoors != other.indoors) return false
        if (forYouthGroups != other.forYouthGroups) return false
        if (volunteerFromAnywhere != other.volunteerFromAnywhere) return false
        if (regionSelected != other.regionSelected) return false
        if (temporaryFakeDistanceScore != other.temporaryFakeDistanceScore) return false
        if (isExternalProject != other.isExternalProject) return false
        if (isUnlistedProject != other.isUnlistedProject) return false
        if (archivedProject != other.archivedProject) return false
        if (isActive != other.isActive) return false
        if (externalVolunteerCount != other.externalVolunteerCount) return false
        if (allEventsFilled != other.allEventsFilled) return false
        if (deleted != other.deleted) return false
        if (relativityScore != other.relativityScore) return false
        if (underReview != other.underReview) return false
        if (id != other.id) return false
        if (projectOwners != null) {
            if (other.projectOwners == null) return false
            if (!projectOwners.contentEquals(other.projectOwners)) return false
        } else if (other.projectOwners != null) return false
        if (location != other.location) return false
        if (ownerLog != null) {
            if (other.ownerLog == null) return false
            if (!ownerLog.contentEquals(other.ownerLog)) return false
        } else if (other.ownerLog != null) return false
        if (projectType != other.projectType) return false
        if (status != other.status) return false
        if (publishDate != other.publishDate) return false
        if (language != other.language) return false
        if (country != other.country) return false
        if (title != other.title) return false
        if (shortDescription != other.shortDescription) return false
        if (longDescription != other.longDescription) return false
        if (logo != other.logo) return false
        if (attachments != null) {
            if (other.attachments == null) return false
            if (!attachments.contentEquals(other.attachments)) return false
        } else if (other.attachments != null) return false
        if (attachmentInfo != null) {
            if (other.attachmentInfo == null) return false
            if (!attachmentInfo.contentEquals(other.attachmentInfo)) return false
        } else if (other.attachmentInfo != null) return false
        if (applicant != other.applicant) return false
        if (contact != other.contact) return false
        if (sponsor != other.sponsor) return false
        if (representative != other.representative) return false
        if (organization != other.organization) return false
        if (fakeDistanceScoreUpdate != other.fakeDistanceScoreUpdate) return false
        if (skills != null) {
            if (other.skills == null) return false
            if (!skills.contentEquals(other.skills)) return false
        } else if (other.skills != null) return false
        if (interests != null) {
            if (other.interests == null) return false
            if (!interests.contentEquals(other.interests)) return false
        } else if (other.interests != null) return false
        if (tools != null) {
            if (other.tools == null) return false
            if (!tools.contentEquals(other.tools)) return false
        } else if (other.tools != null) return false
        if (projectSkills != null) {
            if (other.projectSkills == null) return false
            if (!projectSkills.contentEquals(other.projectSkills)) return false
        } else if (other.projectSkills != null) return false
        if (projectInterests != null) {
            if (other.projectInterests == null) return false
            if (!projectInterests.contentEquals(other.projectInterests)) return false
        } else if (other.projectInterests != null) return false
        if (projectTools != null) {
            if (other.projectTools == null) return false
            if (!projectTools.contentEquals(other.projectTools)) return false
        } else if (other.projectTools != null) return false
        if (externalVolunteerURL != other.externalVolunteerURL) return false
        if (externalVolunteers != null) {
            if (other.externalVolunteers == null) return false
            if (!externalVolunteers.contentEquals(other.externalVolunteers)) return false
        } else if (other.externalVolunteers != null) return false
        if (daysOfWeek != null) {
            if (other.daysOfWeek == null) return false
            if (!daysOfWeek.contentEquals(other.daysOfWeek)) return false
        } else if (other.daysOfWeek != null) return false
        if (timesOfDay != null) {
            if (other.timesOfDay == null) return false
            if (!timesOfDay.contentEquals(other.timesOfDay)) return false
        } else if (other.timesOfDay != null) return false
        if (waiverURL != other.waiverURL) return false
        if (dtl != null) {
            if (other.dtl == null) return false
            if (!dtl.contentEquals(other.dtl)) return false
        } else if (other.dtl != null) return false
        if (onGoing != null) {
            if (other.onGoing == null) return false
            if (!onGoing.contentEquals(other.onGoing)) return false
        } else if (other.onGoing != null) return false
        if (recurring != other.recurring) return false
        if (lastChangeReason != other.lastChangeReason) return false
        if (escalated != other.escalated) return false
        if (created != other.created) return false
        if (updated != other.updated) return false
        if (createdBy != other.createdBy) return false
        if (deletedOn != other.deletedOn) return false
        if (deletedBy != other.deletedBy) return false
        if (firstStartDateTimeOffset != other.firstStartDateTimeOffset) return false
        if (lastEndDateTimeOffset != other.lastEndDateTimeOffset) return false
        if (cbfName != other.cbfName) return false
        if (cblName != other.cblName) return false
        if (updatedBy != other.updatedBy) return false
        if (ubfName != other.ubfName) return false
        if (ublName != other.ublName) return false
        if (volunteerCentersData != null) {
            if (other.volunteerCentersData == null) return false
            if (!volunteerCentersData.contentEquals(other.volunteerCentersData)) return false
        } else if (other.volunteerCentersData != null) return false
        if (projectOwnerName != other.projectOwnerName) return false
        if (projectOwnerLastName != other.projectOwnerLastName) return false
        if (projectOwnerUserId != other.projectOwnerUserId) return false
        if (projectLocationType != other.projectLocationType) return false

        return true
    }

    override fun hashCode(): Int {
        var result = suitableAllAges?.hashCode() ?: 0
        result = 31 * result + (groupProject?.hashCode() ?: 0)
        result = 31 * result + (volunteerRemotely?.hashCode() ?: 0)
        result = 31 * result + (itemDonations?.hashCode() ?: 0)
        result = 31 * result + (wheelchairAccessible?.hashCode() ?: 0)
        result = 31 * result + (indoors?.hashCode() ?: 0)
        result = 31 * result + (forYouthGroups?.hashCode() ?: 0)
        result = 31 * result + (volunteerFromAnywhere?.hashCode() ?: 0)
        result = 31 * result + (regionSelected?.hashCode() ?: 0)
        result = 31 * result + (temporaryFakeDistanceScore?.hashCode() ?: 0)
        result = 31 * result + (isExternalProject?.hashCode() ?: 0)
        result = 31 * result + (isUnlistedProject?.hashCode() ?: 0)
        result = 31 * result + (archivedProject?.hashCode() ?: 0)
        result = 31 * result + (isActive?.hashCode() ?: 0)
        result = 31 * result + (externalVolunteerCount ?: 0)
        result = 31 * result + (allEventsFilled?.hashCode() ?: 0)
        result = 31 * result + deleted.hashCode()
        result = 31 * result + (relativityScore?.hashCode() ?: 0)
        result = 31 * result + (underReview?.hashCode() ?: 0)
        result = 31 * result + (id?.hashCode() ?: 0)
        result = 31 * result + (projectOwners?.contentHashCode() ?: 0)
        result = 31 * result + location.hashCode()
        result = 31 * result + (ownerLog?.contentHashCode() ?: 0)
        result = 31 * result + projectType.hashCode()
        result = 31 * result + status.hashCode()
        result = 31 * result + (publishDate?.hashCode() ?: 0)
        result = 31 * result + (language?.hashCode() ?: 0)
        result = 31 * result + (country?.hashCode() ?: 0)
        result = 31 * result + (title?.hashCode() ?: 0)
        result = 31 * result + (shortDescription?.hashCode() ?: 0)
        result = 31 * result + (longDescription?.hashCode() ?: 0)
        result = 31 * result + (logo?.hashCode() ?: 0)
        result = 31 * result + (attachments?.contentHashCode() ?: 0)
        result = 31 * result + (attachmentInfo?.contentHashCode() ?: 0)
        result = 31 * result + (applicant?.hashCode() ?: 0)
        result = 31 * result + (contact?.hashCode() ?: 0)
        result = 31 * result + (sponsor?.hashCode() ?: 0)
        result = 31 * result + (representative?.hashCode() ?: 0)
        result = 31 * result + (organization?.hashCode() ?: 0)
        result = 31 * result + (fakeDistanceScoreUpdate?.hashCode() ?: 0)
        result = 31 * result + (skills?.contentHashCode() ?: 0)
        result = 31 * result + (interests?.contentHashCode() ?: 0)
        result = 31 * result + (tools?.contentHashCode() ?: 0)
        result = 31 * result + (projectSkills?.contentHashCode() ?: 0)
        result = 31 * result + (projectInterests?.contentHashCode() ?: 0)
        result = 31 * result + (projectTools?.contentHashCode() ?: 0)
        result = 31 * result + (externalVolunteerURL?.hashCode() ?: 0)
        result = 31 * result + (externalVolunteers?.contentHashCode() ?: 0)
        result = 31 * result + (daysOfWeek?.contentHashCode() ?: 0)
        result = 31 * result + (timesOfDay?.contentHashCode() ?: 0)
        result = 31 * result + (waiverURL?.hashCode() ?: 0)
        result = 31 * result + (dtl?.contentHashCode() ?: 0)
        result = 31 * result + (onGoing?.contentHashCode() ?: 0)
        result = 31 * result + (recurring?.hashCode() ?: 0)
        result = 31 * result + (lastChangeReason?.hashCode() ?: 0)
        result = 31 * result + (escalated?.hashCode() ?: 0)
        result = 31 * result + created.hashCode()
        result = 31 * result + updated.hashCode()
        result = 31 * result + (createdBy?.hashCode() ?: 0)
        result = 31 * result + (deletedOn?.hashCode() ?: 0)
        result = 31 * result + (deletedBy?.hashCode() ?: 0)
        result = 31 * result + (firstStartDateTimeOffset?.hashCode() ?: 0)
        result = 31 * result + (lastEndDateTimeOffset?.hashCode() ?: 0)
        result = 31 * result + (cbfName?.hashCode() ?: 0)
        result = 31 * result + (cblName?.hashCode() ?: 0)
        result = 31 * result + (updatedBy?.hashCode() ?: 0)
        result = 31 * result + (ubfName?.hashCode() ?: 0)
        result = 31 * result + (ublName?.hashCode() ?: 0)
        result = 31 * result + (volunteerCentersData?.contentHashCode() ?: 0)
        result = 31 * result + (projectOwnerName?.hashCode() ?: 0)
        result = 31 * result + (projectOwnerLastName?.hashCode() ?: 0)
        result = 31 * result + (projectOwnerUserId?.hashCode() ?: 0)
        result = 31 * result + (projectLocationType?.hashCode() ?: 0)
        return result
    }
}