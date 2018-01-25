package JdkGradlePlugins.buildTypes

import jetbrains.buildServer.configs.kotlin.v2017_2.*

object JdkGradlePlugins_FuncTest : BuildType({
    uuid = "46f193f2-8b0c-4b05-802c-364c1852e219"
    id = "JdkGradlePlugins_FuncTest"
    name = "funcTest"

    vcs {
        root(_Root.vcsRoots.JdkGradlePlugins_HttpsGithubComBreskebyJdkGradlePluginsGit)

        buildDefaultBranch = false
        excludeDefaultBranchChanges = true
    }

    dependencies {
        dependency(JdkGradlePlugins.buildTypes.JdkGradlePlugins_SanityCheck) {
            snapshot {
            }
        }
    }
})
