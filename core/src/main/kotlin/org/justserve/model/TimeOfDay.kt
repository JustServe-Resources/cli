package org.justserve.model

import io.micronaut.serde.annotation.Serdeable

/**
 * JustServe.Contracts.TimeOfDay
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
@Serdeable
enum class TimeOfDay { None, Morning, Afternoon, Evening }
