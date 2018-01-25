package _Root.vcsRoots

import jetbrains.buildServer.configs.kotlin.v2017_2.*
import jetbrains.buildServer.configs.kotlin.v2017_2.vcs.GitVcsRoot

object JdkGradlePlugins_HttpsGithubComBreskebyJdkGradlePluginsGit : GitVcsRoot({
    uuid = "c1cb4c18-beb7-4a15-a988-b8a45046881b"
    id = "JdkGradlePlugins_HttpsGithubComBreskebyJdkGradlePluginsGit"
    name = "https://github.com/breskeby/jdk-gradle-plugins.git"
    url = "https://github.com/breskeby/jdk-gradle-plugins.git"
    branch = "master"
    branchSpec = """
        +:refs/heads/*
        +:refs/(pull/*/head)
    """.trimIndent()
    authMethod = password {
        userName = "breskeby"
        password = "credentialsJSON:9fa99455-2385-48cf-a16a-9a176def2127"
    }
})
