package de.caelis.gitlabdockerupdater.stages.s10_gettags

import de.caelis.gitlabdockerupdater.entities.Tag

class FakeGetTags : IGetTags {

    override fun getTags(): List<Tag> {
        return listOf(
            Tag("11.8.1-ce.0"),
            Tag("11.8.2-ce.0"),
            Tag("11.8.3-ce.0"),
            Tag("11.8.6-ce.0"),
            Tag("11.8.7-ce.0"),
            Tag("11.8.8-ce.0"),
            Tag("11.8.9-ce.0"),
            Tag("11.8.10-ce.0"),
            Tag("11.9.0-ce.0"),
            Tag("11.9.0-rc10.ce.0"),
            Tag("11.9.0-rc3.ce.0"),
            Tag("11.9.0-rc7.ce.0"),
            Tag("11.9.0-rc9.ce.0"),
            Tag("11.9.1-ce.0"),
            Tag("11.9.4-ce.0"),
            Tag("11.9.6-ce.0"),
            Tag("11.9.7-ce.0"),
            Tag("11.9.8-ce.0"),
            Tag("11.9.9-ce.0"),
            Tag("11.9.10-ce.0"),
            Tag("11.9.11-ce.0"),
            Tag("11.9.12-ce.0"),
            Tag("12.0.0-ce.0"),
            Tag("12.0.1-ce.0"),
            Tag("12.0.2-ce.0"),
            Tag("12.0.3-ce.0"),
            Tag("12.0.4-ce.0"),
            Tag("12.0.6-ce.0"),
            Tag("12.0.8-ce.0"),
            Tag("12.0.9-ce.0"),
            Tag("12.0.12-ce.0"),
            Tag("12.1.0-ce.0"),
            Tag("12.1.1-ce.0"),
            Tag("12.2.1-ce.0")
        )
    }
}