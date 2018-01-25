package JdkGradlePlugins.buildTypes

import jetbrains.buildServer.configs.kotlin.v2017_2.BuildType
import jetbrains.buildServer.configs.kotlin.v2017_2.BuildTypeSettings
import jetbrains.buildServer.configs.kotlin.v2017_2.triggers.vcs


class JdkGradlePlugins_Stages_Tested(uuid:String, branch:String) : BuildType({
    this.uuid = uuid
    this.id = "JdkGradlePlugins_${branch}_Stages_Tested"
    this.name = "tested"

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
})
