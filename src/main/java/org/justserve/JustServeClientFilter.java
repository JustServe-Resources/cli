package org.justserve;

import io.micronaut.context.annotation.Property;
import io.micronaut.context.annotation.Requires;
import io.micronaut.http.MutableHttpRequest;
import io.micronaut.http.annotation.ClientFilter;
import io.micronaut.http.annotation.RequestFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@ClientFilter("/**")
@Requires(property = "micronaut.http.services.justserve.token")
public class JustServeClientFilter {
    private final String token;

    private final Logger log = LoggerFactory.getLogger(JustServeClientFilter.class);

    public JustServeClientFilter(@Property(name = "micronaut.http.services.justserve.token") String token) {
        this.token = token;
    }


    @RequestFilter
    public void doFilter(MutableHttpRequest<?> request) {
        log.debug("adding bearer token to request ({})", request.getMethod() + " " + request.getUri());
        request.bearerAuth(token);
    }
}
