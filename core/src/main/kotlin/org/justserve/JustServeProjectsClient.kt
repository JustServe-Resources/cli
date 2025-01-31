package org.justserve

import io.micronaut.core.async.annotation.SingleResult
import io.micronaut.http.HttpHeaders.*
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Header
import io.micronaut.http.annotation.Headers
import io.micronaut.http.annotation.Put
import io.micronaut.http.client.annotation.Client
import org.justserve.model.Project
import org.reactivestreams.Publisher

/**
 * Micronaut http client which consumes the JustServe api at /api/v1/users
 *
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
@Client(id = "justserve", path = "/api/v1/users")
@Headers(
    Header(name = USER_AGENT, value = "Micronaut HTTP Client"),
    Header(name = ACCEPT, value = "application/json, application/json-patch+json, text/json, application/*+json")
)
interface JustServeProjectsClient {
    /**
     * Update a project
     * @param id The id of the project
     * @param organizationId The id of the organization which owns the project
     * @param project The project to update
     * @param sendUpdate Whether to send an update to the project owners
     * @return The updated project
     */
    @Put("/{id}")
    @Header(name = AUTHORIZATION, value = "Bearer {justserve.key}")
    @SingleResult
    fun addProject(
        id: String,
        organizationId: String?,
        sendUpdate: Boolean = false,
        @Body project: Project
    ): Publisher<Project>


}