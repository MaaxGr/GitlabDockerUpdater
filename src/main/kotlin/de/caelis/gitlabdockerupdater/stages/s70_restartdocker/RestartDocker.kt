package de.caelis.gitlabdockerupdater.stages.s70_restartdocker

import de.caelis.gitlabdockerupdater.utils.BashUtils


class RestartDocker : IRestartDocker {

    override fun restartDocker() {

        println("=> Pull image...")
        Thread.sleep(1000)
        val result = BashUtils.executeCommand("docker-compose pull") { println(it) }

        if (result.contains("done")) {
            println("Pulling done!")
        } else {
            println("Error pulling. ABORT. Output was:")
            println(result)
            return;
        }

        println("")
        println("=> Starting docker compose")
        Thread.sleep(1000)
        BashUtils.executeCommand("docker-compose up -d") { println(it) }

        println("")
        println("=> Switching into logs")
        Thread.sleep(1000)
        BashUtils.executeCommand("docker-compose logs -f --tail 10") { println(it) }
    }

}