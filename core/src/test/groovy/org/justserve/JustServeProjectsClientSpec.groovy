package org.justserve

import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import net.datafaker.Faker
import net.datafaker.providers.base.Address
import org.justserve.model.Location
import org.justserve.model.Project
import org.reactivestreams.Publisher
import spock.lang.Shared
import spock.lang.Specification

import static org.justserve.model.OwnerType.ORGANIZATION

@MicronautTest
class JustServeProjectsClientSpec extends Specification {
    @Inject
    JustServeProjectsClient justServeProjectsClient

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

    /**
     * This method returns a Location for an organization. Null values are used for all nullable constructor values.
     * The bounding box coordinates are randomly generated within 100 units (in each direction) of a
     * randomly generated lat/lon.
     * @return Location
     */
    Location getTestLocation() {
        Address address = faker.address()
        var offset = faker.random().nextInt(100)
        return new Location(
                null,
                ORGANIZATION,
                null,null,null,null, null,null,
                null,null,null,null, null,null,
                null,null,null,null,
                Double.valueOf(address.latitude()),
                Double.valueOf(address.longitude()),
                Double.valueOf(address.latitude() + offset),
                Double.valueOf(address.longitude() + offset),
                Double.valueOf(address.latitude() - offset),
                Double.valueOf(address.longitude() - offset),
                false,
                null

        )
    }

}
