package org.justserve.client

import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.client.exceptions.HttpClientResponseException
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import org.justserve.model.UserHashRequestByEmail
import spock.lang.Shared
import spock.lang.Specification

@MicronautTest
class UserClientSpec extends Specification {

    @Inject
    @Shared
    UserClient userClient


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
