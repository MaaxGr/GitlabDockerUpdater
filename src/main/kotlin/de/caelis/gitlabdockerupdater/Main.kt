package de.caelis.gitlabdockerupdater

import de.caelis.gitlabdockerupdater.provider.dockercompose.DockerComposeProvider
import de.caelis.gitlabdockerupdater.provider.dockercompose.FakeDockerComposeProvider
import de.caelis.gitlabdockerupdater.provider.dockercompose.IDockerComposeProvider
import de.caelis.gitlabdockerupdater.stages.s10_gettags.GetTags
import de.caelis.gitlabdockerupdater.stages.s10_gettags.IGetTags
import de.caelis.gitlabdockerupdater.stages.s30_getcurrenttag.GetCurrentTag
import de.caelis.gitlabdockerupdater.stages.s30_getcurrenttag.IGetCurrentTag
import de.caelis.gitlabdockerupdater.stages.s40_getnexttag.GetNextTag
import de.caelis.gitlabdockerupdater.stages.s40_getnexttag.IGetNextTag
import de.caelis.gitlabdockerupdater.stages.s50_backup.Backup
import de.caelis.gitlabdockerupdater.stages.s50_backup.IBackup
import de.caelis.gitlabdockerupdater.stages.s60_setversion.ISetVersion
import de.caelis.gitlabdockerupdater.stages.s60_setversion.SetVersion
import de.caelis.gitlabdockerupdater.stages.s70_restartdocker.IRestartDocker
import de.caelis.gitlabdockerupdater.stages.s70_restartdocker.RestartDocker
import org.koin.core.context.startKoin
import org.koin.dsl.module

fun main() {
    startKoin {
        modules(module {
            single<IDockerComposeProvider> { DockerComposeProvider() }

            single<IGetTags> { GetTags() }
            single<IGetCurrentTag> { GetCurrentTag() }
            single<IGetNextTag> { GetNextTag() }
            single<IBackup> { Backup() }
            single<ISetVersion> { SetVersion() }
            single<IRestartDocker> { RestartDocker() }
        })
    }

    val app = Application()
    app.run()
}