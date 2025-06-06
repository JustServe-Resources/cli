package org.justserve.client


import io.micronaut.http.HttpStatus
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import org.justserve.model.UserHashRequest
import org.justserve.model.UserSearchRequest
import spock.lang.Shared
import spock.lang.Specification

@MicronautTest
class UserClientSpec extends Specification {

    @Inject
    @Shared
    UserClient userClient

    def "search users using slimSearch"() {
        when:
        def response = userClient."${methodName}"(new UserSearchRequest("barney", 0, 10))

        then:
        response.status() == HttpStatus.OK

        and:
        response.body().getUsers() != null

        where:
        methodName       | _
        "userSearchSlim" | _
        "userSearch"     | _
    }

    def "get tempPassword for user"() {
        when:
        def response = userClient.getTempPassword(
                new UserHashRequest("jonathan.zollinger+jimmyhook@gmail.com", null))

        then:
        response.status() == HttpStatus.OK

        and:
        response.body() != null
    }
}
