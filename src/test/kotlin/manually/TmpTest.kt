package manually

import de.caelis.gitlabdockerupdater.Application
import de.caelis.gitlabdockerupdater.provider.dockercompose.FakeDockerComposeProvider
import de.caelis.gitlabdockerupdater.provider.dockercompose.IDockerComposeProvider
import de.caelis.gitlabdockerupdater.stages.s10_gettags.GetTags
import de.caelis.gitlabdockerupdater.stages.s10_gettags.IGetTags
import de.caelis.gitlabdockerupdater.stages.s30_getcurrenttag.GetCurrentTag
import de.caelis.gitlabdockerupdater.stages.s30_getcurrenttag.IGetCurrentTag
import de.caelis.gitlabdockerupdater.stages.s40_getnexttag.GetNextTag
import de.caelis.gitlabdockerupdater.stages.s40_getnexttag.IGetNextTag
import de.caelis.gitlabdockerupdater.stages.s50_backup.FakeBackup
import de.caelis.gitlabdockerupdater.stages.s50_backup.IBackup
import de.caelis.gitlabdockerupdater.stages.s60_setversion.ISetVersion
import de.caelis.gitlabdockerupdater.stages.s60_setversion.SetVersion
import de.caelis.gitlabdockerupdater.utils.BashUtils
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.dsl.module
import org.koin.test.KoinTest

class TmpTest : KoinTest {

    @Test
    fun test() {

        startKoin {
            modules(module {
                single<IDockerComposeProvider> { FakeDockerComposeProvider() }

                single<IGetTags> { GetTags() }
                single<IGetCurrentTag> { GetCurrentTag() }
                single<IGetNextTag> { GetNextTag() }
                single<IBackup> { FakeBackup() }
                single<ISetVersion> { SetVersion() }
            })

            val application = Application()
            application.run()
        }

    }

    @Test
    fun test2() {
        val gettags = GetTags()

        print(gettags.getTags())
    }

    @Test
    fun test3() {
        val cmd = "bash /tmp/touch.sh"
        BashUtils.executeCommand(cmd).also { println(it) }
    }


}