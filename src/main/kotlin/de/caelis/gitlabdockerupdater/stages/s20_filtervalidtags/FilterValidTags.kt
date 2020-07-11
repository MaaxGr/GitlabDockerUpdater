package de.caelis.gitlabdockerupdater.stages.s20_filtervalidtags

import de.caelis.gitlabdockerupdater.entities.Tag

class FilterValidTags : IFilterValidTags {

    override fun filterTags(taglist: List<Tag>): List<Tag> {
        //remove release candidates
        return taglist
            .filter { !it.releaseCandidate }

    }
}