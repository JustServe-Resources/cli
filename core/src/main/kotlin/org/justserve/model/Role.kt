package org.justserve.model

import io.micronaut.serde.annotation.Serdeable

@Serdeable
enum class Role {
    none,
    city,
    county,
    state,
    country,
    orgAdmin,
    orgLeadAdmin,
    stakeAdmin,
    stakeLeadAdmin,
    ccAdmin,
    ccLeadAdmin,
    missionAdmin,
    missionLeadAdmin,
    nationalAdmin,
    nationalLeadAdmin,
    areaAdmin,
    areaLeadAdmin,
    globalAdmin,
    globalLeadAdmin,
    developer
}
