package de.caelis.gitlabdockerupdater.stages.s60_setversion

import de.caelis.gitlabdockerupdater.constants.Constants
import de.caelis.gitlabdockerupdater.entities.Tag
import de.caelis.gitlabdockerupdater.provider.dockercompose.IDockerComposeProvider
import de.caelis.gitlabdockerupdater.utils.RegexUtils
import org.koin.core.KoinComponent
import org.koin.core.inject

class SetVersion : ISetVersion, KoinComponent {

    val dockerCompose: IDockerComposeProvider by inject()

    override fun setVersion(tag: Tag) {
        val oldContent = dockerCompose.getContent()

        val newContent = RegexUtils.replaceGroup(
            Constants.DOCKER_COMPOSE_VERSION_REGEX,
            oldContent,
            1,
            tag.tagName
        )

        dockerCompose.setContent(newContent)
    }

}