package de.caelis.gitlabdockerupdater.constants

import java.util.regex.Pattern

object Constants {

    val DOCKER_IMAGE_TAG_REGEX = Regex("(\\d+).(\\d+).(\\d+)-ce.\\d")
    val DOCKER_COMPOSE_VERSION_REGEX = Regex("gitlab\\/gitlab-ce:(.+)")
    val DOCKER_COMPOSE_CONTAINER_NAME_REGEX = Regex("container_name: ?(.+)")

}