package org.justserve

import io.micronaut.context.annotation.Property
import io.micronaut.context.annotation.Requires
import io.micronaut.http.MutableHttpRequest
import io.micronaut.http.annotation.ClientFilter
import io.micronaut.http.annotation.RequestFilter

@ClientFilter("/**")
@Requires(property = "justserve.key")
class AuthFilter(@Property(name = "justserve.key") private val key: String) {

    @Override
    @RequestFilter
    fun doFilter(request: MutableHttpRequest<*>) { request.bearerAuth(key) }
}