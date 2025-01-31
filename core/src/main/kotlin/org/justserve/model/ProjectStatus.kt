package org.justserve.model

/**
 * JustServe.Contracts.ProjectStatus
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
enum class ProjectStatus(val value: Int) {
    None(0),
    Published(1),
    Submitted(2),
    Draft(3),
    Template(4),
    OnHold(5),
    Cancelled(6),
    Declined(7)
}