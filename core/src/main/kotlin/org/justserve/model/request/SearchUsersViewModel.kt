package org.justserve.model.request

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.serde.annotation.Serdeable

/**
 * Search query for users
 */
@Serdeable
data class SearchUsersViewModel @JvmOverloads constructor(
    @JsonProperty("value") var searchQuery: String,
    var page: Int = 0,
    var size: Int = 0,
    var orderBy: String? = null
) {}