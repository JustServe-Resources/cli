package org.justserve.model

import io.micronaut.serde.annotation.Serdeable

/**
 * JustServe.Contracts.Location
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
@Serdeable
data class Location(
    val id: String?,
    val ownerType: OwnerType,
    val mapId: String?,
    val fullDisplayAddress: String?,
    val address: String?,
    val suite: String?,
    val city: String?,
    val civicCityId: String?,
    val neighborhood: String?,
    val county: String?,
    val state: String?,
    val postal: String?,
    val country: String?,
    val countryCode: String?,
    val missionId: String?,
    val ccId: String?,
    val stakeId: String?,
    val areaId: String?,
    val latitude: Double,
    val longitude: Double,
    val maxLatitude: Double,
    val minLatitude: Double,
    val maxLongitude: Double,
    val minLongitude: Double,
    val geoCodeOverride: Boolean,
    val timezone: String?
)