package de.caelis.gitlabdockerupdater.stages.s30_getcurrenttag

import de.caelis.gitlabdockerupdater.constants.Constants
import de.caelis.gitlabdockerupdater.entities.Tag
import de.caelis.gitlabdockerupdater.provider.dockercompose.IDockerComposeProvider
import de.caelis.gitlabdockerupdater.utils.extensions.getGroupValueFor
import org.koin.core.KoinComponent
import org.koin.core.inject

class GetCurrentTag() : IGetCurrentTag, KoinComponent {

    private val dockerCompose: IDockerComposeProvider by inject()

    override fun getCurrentTag(): Tag {
        val dockerComposeContent = dockerCompose.getContent()

        val versionTagString = Constants.DOCKER_COMPOSE_VERSION_REGEX
            .getGroupValueFor(dockerComposeContent, 1)

            ?: throw IllegalArgumentException("No tag set")

        val tag = Tag(versionTagString)

        return tag
    }

}