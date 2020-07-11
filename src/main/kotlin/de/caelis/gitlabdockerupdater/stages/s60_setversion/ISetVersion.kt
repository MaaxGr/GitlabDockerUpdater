package de.caelis.gitlabdockerupdater.stages.s60_setversion

import de.caelis.gitlabdockerupdater.entities.Tag

interface ISetVersion {

    fun setVersion(tag: Tag)

}