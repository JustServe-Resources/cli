package org.justserve.client

import io.micronaut.context.ApplicationContext
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.client.exceptions.HttpClientResponseException
import io.micronaut.runtime.server.EmbeddedServer
import org.justserve.model.UserHashRequestByEmail
import spock.lang.Shared
import spock.lang.Specification

class UserClientSpec extends Specification {

    @Shared
    ApplicationContext noAuthCtx

    @Shared
    ApplicationContext ctx

    @Shared
    UserClient noAuthUserClient

    @Shared
    UserClient userClient

    void setupSpec() {
        def justServeUrl = System.getenv("JUSTSERVE_URL") ?: "https://www.justserve.org"
        if (null != System.getenv("JUSTSERVE_TOKEN")) {
            throw new IllegalStateException("JUSTSERVE_TOKEN is set. Do not define this variable in testing.")
        }
        noAuthCtx = ApplicationContext.builder(EmbeddedServer)
                .environmentVariableExcludes("JUSTSERVE_TOKEN", "TEST_TOKEN")
                .properties(["micronaut.http.services.justserve.url": justServeUrl])
                .build()
                .start()
        noAuthUserClient = noAuthCtx.getBean(UserClient)
        ctx = ApplicationContext.builder(EmbeddedServer)
                .environmentVariableExcludes("JUSTSERVE_TOKEN")
                .properties([
                        "justserve.token"                      : System.getenv("MICRONAUT_HTTP_SERVICES_JUSTSERVE_TOKEN"),
                        "micronaut.http.services.justserve.url": justServeUrl
                ])
                .build()
                .start()
        userClient = ctx.getBean(UserClient)
    }

    void cleanupSpec() {
        noAuthCtx.stop()
        ctx.stop()
    }

    def "get tempPassword for #email and "() {
        when:
        HttpResponse<String> response = null
        def caughtException = null
        def message = null
        try {
            response = client.getTempPassword(new UserHashRequestByEmail(email))
        } catch (e) {
            caughtException = e.class
            message = e.message
        }

        then:
        if (null != caughtException) {
            verifyAll {
                caughtException == expectedException
                message.contains(expectedMessage)
            }
        } else {
            verifyAll {
                expectedResponse == response.status()
                response.body() != null
            }
        }

        where:
        expectedResponse | email                 | expectedException           | expectedMessage  | client           | _
        HttpStatus.OK    | "jimmy@justserve.org" | null                        | null             | userClient       | _
        null             | "notanemail@mail.moc" | HttpClientResponseException | "\"status\":500" | userClient       | _
        null             | "jimmy@justserve.org" | HttpClientResponseException | "\"status\":401" | noAuthUserClient | _
        null             | "notanemail@mail.moc" | HttpClientResponseException | "\"status\":401" | noAuthUserClient | _
    }
}
