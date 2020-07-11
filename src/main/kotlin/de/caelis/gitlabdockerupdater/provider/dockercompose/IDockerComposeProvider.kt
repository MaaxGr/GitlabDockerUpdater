package de.caelis.gitlabdockerupdater.provider.dockercompose

interface IDockerComposeProvider {

    fun getContent(): String

    fun setContent(content: String)

}