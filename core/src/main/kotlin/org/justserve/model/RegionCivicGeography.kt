package org.justserve.model

import io.micronaut.serde.annotation.Serdeable

/**
 * JustServe.model.RegionCivicGeography
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
@Serdeable
data class RegionCivicGeography(
    val type: GeographyType,
    val name: String,
    val id: String
)
