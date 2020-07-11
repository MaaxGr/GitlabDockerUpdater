package de.caelis.gitlabdockerupdater.entities

import de.caelis.gitlabdockerupdater.constants.Constants

class Tag (
    val tagName: String
) {

    val valid: Boolean
    val majorVersion: Int
    val minorVersion: Int
    val patchVersion: Int

    init {
        val result = Constants.DOCKER_IMAGE_TAG_REGEX
            .find(tagName)

        valid = result != null

        if (result != null) {
            val (major, minor, patch) = result.destructured
            majorVersion = major.toIntOrNull() ?: -1
            minorVersion = minor.toIntOrNull() ?: -1
            patchVersion = patch.toIntOrNull() ?: -1
        } else {
            majorVersion = -1
            minorVersion = -1
            patchVersion = -1
        }
    }

    val releaseCandidate: Boolean
        get() = tagName.contains("rc")

    override fun toString(): String {
        return tagName
    }

    override fun equals(other: Any?): Boolean {
        if (other is Tag) {
            return this.tagName == other.tagName
        }
        return false
    }

}