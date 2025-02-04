package org.justserve

import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import net.datafaker.Faker
import org.justserve.model.Project
import org.justserve.model.ProjectStatus
import org.justserve.model.ProjectType
import spock.lang.Shared
import spock.lang.Specification

@MicronautTest
class JustServeProjectsClientSpec extends Specification {
    @Inject
    UsersClient justServeProjectsClient

    @Shared
    @Inject
    Faker faker;

    void "add a new project from scratch"() {
        when: "create a new test project object"
        Project project = DataUtils.getTestProject(
                DataUtils.getTestOrgLocation(faker),
                projectType as ProjectType,
                status as ProjectStatus,
                "2022-01-01",
                "2022-01-01",
                false)

        then: "attempt adding it to the system"
//

        where:
        projectType << ProjectType.values()
        status << ProjectStatus.values()
    }

}
