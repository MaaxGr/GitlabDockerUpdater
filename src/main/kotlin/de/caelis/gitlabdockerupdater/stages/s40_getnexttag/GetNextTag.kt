package de.caelis.gitlabdockerupdater.stages.s40_getnexttag

import de.caelis.gitlabdockerupdater.entities.Tag
import de.caelis.gitlabdockerupdater.utils.filterMinBy

class GetNextTag : IGetNextTag {

    override fun getNextTag(allTags: List<Tag>, currentTag: Tag): Tag? {

        // check if new minor version
        val newMinorVersions = allTags.filter {
            it.majorVersion == currentTag.majorVersion
                    && it.minorVersion > currentTag.minorVersion
        }

        if (newMinorVersions.isNotEmpty()) {
            // get lowest minor version with biggest patch version
            return newMinorVersions
                .filterMinBy { it.minorVersion }
                .maxBy { it.patchVersion }
        }

        // if no minor version found, search for major version
        val nextMajorTag = allTags
            .filter { it.majorVersion > currentTag.majorVersion }
            .filterMinBy { it.majorVersion }
            .filterMinBy { it.minorVersion }
            .maxBy { it.patchVersion }

        if (nextMajorTag != null) {
            return nextMajorTag
        }

        // if no major version found, search for patch version
        return allTags
            .filter { it.majorVersion == currentTag.majorVersion }
            .filter { it.minorVersion == currentTag.minorVersion }
            .filter { it.patchVersion > currentTag.patchVersion }
            .maxBy { it.patchVersion }
    }
}