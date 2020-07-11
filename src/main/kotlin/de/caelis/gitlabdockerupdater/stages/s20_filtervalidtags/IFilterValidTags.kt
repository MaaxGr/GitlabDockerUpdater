package de.caelis.gitlabdockerupdater.stages.s20_filtervalidtags

import de.caelis.gitlabdockerupdater.entities.Tag

interface IFilterValidTags {

    fun filterTags(taglist: List<Tag>): List<Tag>

}