package org.justserve.model

/**
 * JustServe.model.GeographyType
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
enum class GeographyType(val value: Int) {
    All(0),
    Area(1),
    Mission(2),
    CC(3),
    Stake(4),
    Country(5),
    State(6),
    County(7),
    City(8),
    Zipcode(9),
    Neighborhood(10),
    National(11),
    None(12)
}
