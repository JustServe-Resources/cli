package org.justserve

import io.micronaut.context.annotation.Value
import io.micronaut.core.async.annotation.SingleResult
import io.micronaut.http.HttpHeaders.*
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.*
import io.micronaut.http.client.annotation.Client
import org.justserve.model.Project
import org.justserve.model.request.SearchUsersViewModel
import org.justserve.model.response.AdminPendingProjectsResponse
import org.justserve.model.response.UserSearchResults
import org.reactivestreams.Publisher

/**
 * Micronaut http client which consumes the JustServe api at /api/v1/users
 *
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
@Client(id = "justserve")
@Headers(
    Header(name = USER_AGENT, value = "Micronaut HTTP Client"),
    Header(name = ACCEPT, value = "application/json, application/json-patch+json, text/json, application/*+json")
)
interface UsersClient {
    /**
     * Update a project
     * @param id The id of the project
     * @param organizationId The id of the organization which owns the project
     * @param project The project to update
     * @param sendUpdate Whether to send an update to the project owners
     * @return The updated project
     */
    @Put("/{id}") //is this really accurate? api/v1/users/<id> creates a project?
    @SingleResult
    fun addProject(
        id: String,
        organizationId: String?,
        sendUpdate: Boolean = false,
        @Body project: Project
    ): Publisher<Project>


    /**
     * Retrieve a list of pending projects for an admin user
     *
     * @param userID The id of the user
     * @param adminSubordinateFilterModifier A modifier to control which projects are returned. //TODO: document this
     * @param page The index of the page of results to return
     * @param size The number of results to return per page
     * @return A list of projects
     */
    @Post("/{userID}/adminPendingProjects")
    fun getAdminPendingProjects(
        userID: String,
        @Body adminSubordinateFilterModifier: Int,
        @Body page: Int, @Body size: Int
    ): Publisher<AdminPendingProjectsResponse>

    @Post("/search")
    fun userSearch(searchQuery: SearchUsersViewModel): Publisher<UserSearchResults>


}