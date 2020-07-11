package de.caelis.gitlabdockerupdater.stages.s50_backup

class FakeBackup : IBackup {

    override fun backup(): Boolean {
        return true
    }

}