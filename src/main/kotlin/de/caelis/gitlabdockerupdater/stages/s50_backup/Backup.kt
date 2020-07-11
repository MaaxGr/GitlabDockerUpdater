package de.caelis.gitlabdockerupdater.stages.s50_backup

import de.caelis.gitlabdockerupdater.constants.Constants
import de.caelis.gitlabdockerupdater.provider.dockercompose.IDockerComposeProvider
import de.caelis.gitlabdockerupdater.utils.BashUtils
import de.caelis.gitlabdockerupdater.utils.extensions.getGroupValueFor
import org.koin.core.KoinComponent
import org.koin.core.inject
import java.lang.Exception

class Backup : IBackup, KoinComponent {

    private val dockerCompose: IDockerComposeProvider by inject()

    override fun backup(): Boolean {
        val containerName = Constants.DOCKER_COMPOSE_CONTAINER_NAME_REGEX
            .getGroupValueFor(dockerCompose.getContent(), 1)

        val backupCmd = "docker exec -t $containerName gitlab-rake gitlab:backup:create SKIP=artifacts,repositories"
        val result = BashUtils.executeCommand(backupCmd)

        val okMessage = "Backup task is done."
        val ok = result.contains(okMessage)

        if (!ok) {
            print("Result: $result")
            throw Exception("Backup result message doens't contain '$okMessage'")
        } else {
        }

        return ok
    }
}