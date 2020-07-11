package de.caelis.gitlabdockerupdater.utils.extensions

fun Regex.getGroupValueFor(string: String, groupIndex: Int): String? {
    return find(string)?.groupValues?.get(groupIndex)
}