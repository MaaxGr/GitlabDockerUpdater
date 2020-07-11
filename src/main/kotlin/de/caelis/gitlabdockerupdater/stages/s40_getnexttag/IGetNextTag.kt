package de.caelis.gitlabdockerupdater.stages.s40_getnexttag

import de.caelis.gitlabdockerupdater.entities.Tag

interface IGetNextTag {

    fun getNextTag(allTags: List<Tag>, currentTag: Tag): Tag?

}