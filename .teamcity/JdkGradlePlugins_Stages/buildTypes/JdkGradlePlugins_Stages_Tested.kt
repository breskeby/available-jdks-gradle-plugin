package JdkGradlePlugins_Stages.buildTypes

import jetbrains.buildServer.configs.kotlin.v2017_2.*
import jetbrains.buildServer.configs.kotlin.v2017_2.triggers.vcs

object JdkGradlePlugins_Stages_Tested : BuildType({
    uuid = "df62e6ab-5d42-455f-8a68-7fe73b3e7aba"
    id = "JdkGradlePlugins_Stages_Tested"
    name = "tested"

    type = BuildTypeSettings.Type.COMPOSITE

    vcs {
        root(_Root.vcsRoots.JdkGradlePlugins_HttpsGithubComBreskebyJdkGradlePluginsGit)

        buildDefaultBranch = false
        excludeDefaultBranchChanges = true
        showDependenciesChanges = true
    }

    triggers {
        vcs {
            triggerRules = """
                +:refs/heads/
                +:refs/(pull/*/head)
            """.trimIndent()
        }
    }

    dependencies {
        dependency(JdkGradlePlugins.buildTypes.JdkGradlePlugins_FuncTest) {
            snapshot {
            }
        }
        dependency(JdkGradlePlugins.buildTypes.JdkGradlePlugins_UnitTest) {
            snapshot {
            }
        }
    }
})
