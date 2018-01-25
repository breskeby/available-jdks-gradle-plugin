package _Root.vcsRoots

import jetbrains.buildServer.configs.kotlin.v2017_2.*
import jetbrains.buildServer.configs.kotlin.v2017_2.vcs.GitVcsRoot

object Gradle_Master : GitVcsRoot({
    uuid = "1e6d97ed-d569-4637-a052-f0d9398ea79b"
    id = "Gradle_Master"
    name = "Gradle Master"
    url = "git://github.com/gradle/gradle.git"
    branch = "master"
    useMirrors = false
})
