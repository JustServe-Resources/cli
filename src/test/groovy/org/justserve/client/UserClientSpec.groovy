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
        if (null != System.getenv("JUSTSERVE_TOKEN")) {
            throw new IllegalStateException("JUSTSERVE_TOKEN is set. Do not define this variable in testing.")
        }
        noAuthCtx = ApplicationContext.builder(EmbeddedServer)
                .environmentVariableExcludes("JUSTSERVE_TOKEN")
                .build()
                .start()
        noAuthUserClient = noAuthCtx.getBean(UserClient)
        ctx = ApplicationContext.builder(EmbeddedServer)
                .environmentVariableExcludes("JUSTSERVE_TOKEN")
                .properties([
                        "JUSTSERVE_TOKEN": System.getenv("TEST_TOKEN")
                ])
                .build()
                .start()
        userClient = noAuthCtx.getBean(UserClient)
    }

    void cleanupSpec() {
        noAuthCtx.stop()
        ctx.stop()
    }

    def "get tempPassword for #email"() {
        when:
        HttpResponse<String> response = null
        def caughtException = null
        try {
            response = userClient.getTempPassword(new UserHashRequestByEmail(email))
        } catch (e) {
            caughtException = e.class
        }

        then:
        if (null != caughtException) {
            caughtException == expectedException
        } else {
            expectedResponse == response.status()
            response.body() != null
        }

        where:
        expectedResponse | email                 | expectedException
        HttpStatus.OK    | "jimmy@justserve.org" | null
        null             | "notanemail@mail.moc" | HttpClientResponseException
    }
}
