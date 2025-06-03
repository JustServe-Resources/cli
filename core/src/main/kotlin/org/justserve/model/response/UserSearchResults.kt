package org.justserve.model.response

data class UserSearchResults @JvmOverloads constructor(
    var count: Int,
    var users: List<UserSearchResult>? = null
) {}
