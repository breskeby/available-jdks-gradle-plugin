package JdkGradlePlugins.buildTypes

import jetbrains.buildServer.configs.kotlin.v2017_2.BuildType

class JdkGradlePlugins_Branch(uuid: String, branch: String) : BuildType({
    this.uuid = uuid
    this.id = "JdkGradlePlugins_${branch}"
    this.name = "JdkGradlePlugins${branch}"

    vcs {
        root(_Root.vcsRoots.JdkGradlePlugins_HttpsGithubComBreskebyJdkGradlePluginsGit)

        buildDefaultBranch = false
        excludeDefaultBranchChanges = true
    }
})
