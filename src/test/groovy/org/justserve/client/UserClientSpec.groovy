package org.justserve.client

import io.micronaut.http.HttpStatus
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import org.justserve.model.UserHashRequest
import spock.lang.Shared
import spock.lang.Specification

@MicronautTest
class UserClientSpec extends Specification {

    @Inject
    @Shared
    UserClient userClient


    def "get tempPassword for user"() {
        when:
        def response = userClient.getTempPassword(
                new UserHashRequest("jimmy@justserve.org", null))

        then:
        response.status() == HttpStatus.OK

        and:
        response.body() != null
    }
}
