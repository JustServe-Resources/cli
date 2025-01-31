package org.justserve

import io.micronaut.http.HttpHeaders.ACCEPT
import io.micronaut.http.HttpHeaders.USER_AGENT
import io.micronaut.http.annotation.Header
import io.micronaut.http.annotation.Headers
import io.micronaut.http.client.annotation.Client

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

}