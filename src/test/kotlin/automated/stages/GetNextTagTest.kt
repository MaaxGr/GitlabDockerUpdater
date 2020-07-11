package automated.stages

import de.caelis.gitlabdockerupdater.entities.Tag
import de.caelis.gitlabdockerupdater.stages.s40_getnexttag.GetNextTag
import org.junit.Assert
import org.junit.Test
import java.io.File

class GetNextTagTest {

    @Test
    fun newMinor() {
        val allTags = listOf(
            Tag("12.0.8-ce.0"),
            Tag("12.0.9-ce.0"),
            Tag("12.0.12-ce.0"),
            Tag("12.1.0-ce.0"),
            Tag("12.1.1-ce.0"),
            Tag("12.2.1-ce.0")
        )
        val currentTag = Tag("12.0.9-ce.0")
        val expectedNextTag = Tag("12.1.1-ce.0")

        val stage = GetNextTag()

        val realNextTag = stage.getNextTag(allTags, currentTag)

        Assert.assertEquals(expectedNextTag, realNextTag)
    }

    @Test
    fun newMajor() {
        val allTags = listOf(
            Tag("12.0.8-ce.0"),
            Tag("12.0.9-ce.0"),
            Tag("12.0.12-ce.0"),
            Tag("12.1.0-ce.0"),
            Tag("12.1.1-ce.0"),
            Tag("12.2.1-ce.0"),
            Tag("13.0.1-ce.0"),
            Tag("13.0.3-ce.0"),
            Tag("13.1.1-ce.0")
        )
        val expectedNextTag = Tag("13.0.3-ce.0")
        val currentTag = Tag("12.2.1-ce.0")

        val stage = GetNextTag()

        val realNextTag = stage.getNextTag(allTags, currentTag)

        Assert.assertEquals(expectedNextTag, realNextTag)

        val pb = ProcessBuilder()
        pb.redirectOutput(File(""))

    }

}