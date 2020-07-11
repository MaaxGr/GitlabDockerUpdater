package de.caelis.gitlabdockerupdater.utils

import java.util.regex.Matcher
import java.util.regex.Pattern

object RegexUtils {

    fun replaceGroup(
        regex: Regex,
        source: String,
        groupToReplace: Int,
        replacement: String?
    ): String {
        return replaceGroup(regex, source, groupToReplace, 1, replacement)
    }

    fun replaceGroup(
        regex: Regex,
        source: String,
        groupToReplace: Int,
        groupOccurrence: Int,
        replacement: String?
    ): String {
        val m: Matcher = regex.toPattern().matcher(source)
        for (i in 0 until groupOccurrence) if (!m.find()) return source // pattern not met, may also throw an exception here

        return StringBuilder(source).replace(m.start(groupToReplace), m.end(groupToReplace), replacement).toString()
    }


}