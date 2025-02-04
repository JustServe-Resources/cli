package org.justserve

import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import net.datafaker.Faker
import org.justserve.model.Project
import spock.lang.Shared
import spock.lang.Specification

@MicronautTest
class JustServeProjectsClientSpec extends Specification {
    @Inject
    UsersClient justServeProjectsClient

    @Shared
    Faker faker;

    setup() {
        faker = new Faker();
    }

    void tireKick() {
//        when:
//        Publisher<Project> project = justServeProjectsClient.addProject(testProject)
        //TODO: figure solid way to generate fake project data
    }

}
