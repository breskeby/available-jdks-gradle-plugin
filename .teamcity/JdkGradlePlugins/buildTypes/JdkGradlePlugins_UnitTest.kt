package JdkGradlePlugins.buildTypes

import jetbrains.buildServer.configs.kotlin.v2017_2.BuildType

object JdkGradlePlugins_UnitTest : BuildType({
    uuid = "0188d04b-e3bb-4e6e-bfe2-52f2ce62942b"
    id = "JdkGradlePlugins_UnitTest"
    name = "unitTest"

    vcs {
        root(_Root.vcsRoots.JdkGradlePlugins_HttpsGithubComBreskebyJdkGradlePluginsGit)

        buildDefaultBranch = false
    }

    dependencies {
        dependency(JdkGradlePlugins.buildTypes.JdkGradlePlugins_SanityCheck("master")) {
            snapshot {
            }
        }
    }
})
