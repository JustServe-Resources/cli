package org.justserve.model

import io.micronaut.serde.annotation.Serdeable

/**
 * JustServe.Contracts.Location
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
@Serdeable
data class Location @JvmOverloads constructor(
    val id: String? = null,
    val ownerType: OwnerType,
    val mapId: String? = null,
    val fullDisplayAddress: String? = null,
    val address: String? = null,
    val suite: String? = null,
    val city: String? = null,
    val civicCityId: String? = null,
    val neighborhood: String? = null,
    val county: String? = null,
    val state: String? = null,
    val postal: String? = null,
    val country: String? = null,
    val countryCode: String? = null,
    val missionId: String? = null,
    val ccId: String? = null,
    val stakeId: String? = null,
    val areaId: String? = null,
    val latitude: Double,
    val longitude: Double,
    val maxLatitude: Double,
    val minLatitude: Double,
    val maxLongitude: Double,
    val minLongitude: Double,
    val geoCodeOverride: Boolean = false,
    val timezone: String? = null
)