package de.caelis.gitlabdockerupdater.stages.s10_gettags

import de.caelis.gitlabdockerupdater.entities.Tag

interface IGetTags {

    fun getTags(): List<Tag>

}