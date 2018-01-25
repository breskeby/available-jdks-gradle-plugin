package _Root.vcsRoots

import jetbrains.buildServer.configs.kotlin.v2017_2.*
import jetbrains.buildServer.configs.kotlin.v2017_2.vcs.GitVcsRoot

object Gradle_Branches_VersionedSettings : GitVcsRoot({
    uuid = "ff0bab04-72a7-423c-b969-f99126ee4f27"
    id = "Gradle_Branches_VersionedSettings"
    name = "Gradle Versioned Settings"
    url = "git@github.com:gradle/gradle.git"
    branch = "teamcity-versioned-settings"
    authMethod = uploadedKey {
        uploadedKey = "id_rsa_gradlewaregitbot"
    }
})
