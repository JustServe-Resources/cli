package org.justserve

import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import org.justserve.model.request.SearchUsersViewModel
import spock.lang.Specification
import reactor.core.publisher.Mono

@MicronautTest
class UserClientSpec extends Specification{
    @Inject
    UsersClient usersClient

    def "can get a user's pending projects"() {
        when:
        var response = usersClient.userSearch(new SearchUsersViewModel("Zollinger"))

        then:
        Mono.from(response).block() != null

    }

}
