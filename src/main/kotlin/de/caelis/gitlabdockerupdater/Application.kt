package de.caelis.gitlabdockerupdater

import de.caelis.gitlabdockerupdater.constants.ConsoleColor
import de.caelis.gitlabdockerupdater.constants.ConsoleColor.yellowBold
import de.caelis.gitlabdockerupdater.stages.s10_gettags.IGetTags
import de.caelis.gitlabdockerupdater.stages.s30_getcurrenttag.IGetCurrentTag
import de.caelis.gitlabdockerupdater.stages.s40_getnexttag.IGetNextTag
import de.caelis.gitlabdockerupdater.stages.s50_backup.IBackup
import de.caelis.gitlabdockerupdater.stages.s60_setversion.ISetVersion
import de.caelis.gitlabdockerupdater.stages.s70_restartdocker.IRestartDocker
import org.koin.core.KoinComponent
import org.koin.core.inject

class Application : KoinComponent {

    private val getTagsStage: IGetTags by inject()
    private val getCurrentTagStage: IGetCurrentTag by inject()
    private val getNextTagStage: IGetNextTag by inject()
    private val backupStage: IBackup by inject()
    private val setVersionStage: ISetVersion by inject()
    private val restartDocker: IRestartDocker by inject()

    init {

    }

    fun run() {
        // get all tags and filter release candidates versions
        val tags = getTagsStage.getTags()
            .filter { !it.releaseCandidate }

        // get current tag
        val currentTag = getCurrentTagStage.getCurrentTag()
        println("${yellowBold("Current Tag:")} $currentTag")

        // get next tag
        val nextTag = getNextTagStage.getNextTag(tags, currentTag)
        println("${yellowBold("Next Tag:")} $nextTag")

        if (nextTag == null) {
            return
        }

        println("Starting backup...")
        backupStage.backup()

        println("Backup ok")

        Thread.sleep(2000)

        setVersionStage.setVersion(nextTag)

        restartDocker.restartDocker()
    }

}