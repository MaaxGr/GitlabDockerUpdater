package de.caelis.gitlabdockerupdater.stages.s10_gettags

import de.caelis.gitlabdockerupdater.entities.Tag
import de.caelis.gitlabdockerupdater.utils.BashUtils

class GetTags : IGetTags {
    override fun getTags(): List<Tag> {

        val command = "wget -q https://registry.hub.docker.com/v1/repositories/gitlab/gitlab-ce/tags -O - | sed -e 's/[][]//g' -e 's/\"//g' -e 's/ //g' | tr '}' '\\n' | awk -F: '{print \$3}'"

        val result = BashUtils.executeCommand(command)

        return result.split(System.lineSeparator()).map { Tag(it) }
    }
}