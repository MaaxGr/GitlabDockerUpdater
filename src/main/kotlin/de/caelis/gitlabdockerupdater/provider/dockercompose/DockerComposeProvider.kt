package de.caelis.gitlabdockerupdater.provider.dockercompose

import java.io.File

class DockerComposeProvider : IDockerComposeProvider {
    override fun getContent(): String {
        return File("docker-compose.yml").readText()
    }

    override fun setContent(content: String) {
        File("docker-compose.yml").writeText(content)
    }
}