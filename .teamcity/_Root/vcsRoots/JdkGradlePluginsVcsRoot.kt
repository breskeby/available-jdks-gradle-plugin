package _Root.vcsRoots;

import jetbrains.buildServer.configs.kotlin.v2017_2.vcs.GitVcsRoot

open class JdkGradlePluginsVcsRoot(branch: String, config: (gvr: GitVcsRoot) -> kotlin.Unit = {}) : GitVcsRoot( {
    this.id = "JdkGradlePlugins_HttpsGithubComBreskebyJdkGradlePluginsGit_${branch}"
    this.uuid = id
    this.name = "https://github.com/breskeby/jdk-gradle-plugins.git#${branch}"
    this.url = "https://github.com/breskeby/jdk-gradle-plugins.git"
    this.branch = branch
    this.authMethod = password {
        userName = "breskeby"
        password = "credentialsJSON:9fa99455-2385-48cf-a16a-9a176def2127"
    }

    config.invoke(this)
})

object JdkGradlePluginsVcsRootMaster : JdkGradlePluginsVcsRoot("master")
object JdkGradlePluginsVcsRootRelease : JdkGradlePluginsVcsRoot("release")
