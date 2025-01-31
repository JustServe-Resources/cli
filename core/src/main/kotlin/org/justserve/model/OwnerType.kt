@file:Suppress("unused")
package org.justserve.model

/**
 * JustServe.model.OwnerType
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
data class OwnerType(val value: Int) {
    companion object {
        const val USER = 1
        const val ORGANIZATION = 2
    }
}