package org.justserve.model

/**
 * JustServe.Contracts.Enums.ProjectLocationType
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
enum class ProjectLocationType(val value: Int) {
    None(0),
    SingleLocation(1),
    Regional(2),
    Remote(3)
}
