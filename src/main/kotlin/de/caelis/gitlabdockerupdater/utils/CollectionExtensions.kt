package de.caelis.gitlabdockerupdater.utils

fun <E, R : Comparable<R>> Collection<E>.filterMinBy(function: (E) -> R): List<E> {
    return filter { function(it) == this.map { function(it) }.min() }
}