package org.justserve


import net.datafaker.Faker
import net.datafaker.providers.base.Address
import org.justserve.model.Location
import org.justserve.model.OwnerType

import static org.justserve.model.OwnerType.ORGANIZATION
import static org.justserve.model.OwnerType.USER

/**
 *
 */
class DataUtils {

    /**
     * Returns a location for an organization. Null values are used for all nullable constructor values.
     * The bounding box coordinates are randomly generated within 100 units (in each direction) of a
     * randomly generated lat/long.
     * @return Location object with fake data.
     */
    static Location getTestOrgLocation(Faker faker = new Faker()) {
        return getTestLocation(faker, ORGANIZATION)
    }

    /**
     * Returns a Location for a user. Null values are used for all nullable constructor values.
     * The bounding box coordinates are randomly generated within 100 units (in each direction) of a
     * randomly generated lat/long.
     * @return Location
     */
    static Location getTestUserLocation(Faker faker = new Faker()) {
        return getTestLocation(faker, USER)
    }

    /**
     * This method returns a Location. Null values are used for all nullable constructor values. The bounding box is
     * generated within a random offset from the provided latLongOffsetMax.
     *
     * @param faker optional faker instance, or a new one will be created
     * @param ownerType the owner type, either USER or ORGANIZATION
     * @param latLongOffsetMax the inclusive maximum offset from the lat/lon
     * @return Location
     */
    private static Location getTestLocation(Faker faker = new Faker(), OwnerType ownerType, Integer latLongOffsetMax = 100) {
        Address address = faker.address()
        double offset = faker.random().nextInt(latLongOffsetMax)
        return new Location(
                ownerType,
                Double.valueOf(address.latitude()),
                Double.valueOf(address.longitude()),
                Double.valueOf(address.latitude() + offset),
                Double.valueOf(address.longitude() + offset),
                Double.valueOf(address.latitude() - offset),
                Double.valueOf(address.longitude() - offset),
        )
    }
}
