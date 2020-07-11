package de.caelis.gitlabdockerupdater.stages.s30_getcurrenttag

import de.caelis.gitlabdockerupdater.entities.Tag

interface IGetCurrentTag {

    fun getCurrentTag(): Tag


}