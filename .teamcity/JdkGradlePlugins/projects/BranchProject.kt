package JdkGradlePlugins.projects

import JdkGradlePlugins.buildTypes.JdkGradlePlugins_SanityCheck
import JdkGradlePlugins.buildTypes.JdkGradlePlugins_Stage_Trigger_BT
import jetbrains.buildServer.configs.kotlin.v2017_2.Project


class BranchProject(branch: String, uuid: String) : Project({
    this.uuid = uuid
    id = "JdkGradlePlugins_$branch"
    parentId = "JdkGradlePlugins"
    name = branch

    subProjects(
            Project({
                this.uuid = "${uuid}-stages"
                id = "JdkGradlePlugins_${branch}_Stages"
                name = "Stages"
                buildType(JdkGradlePlugins_Stage_Trigger_BT(uuid + "_$branch", branch, {
                    it.vcs {
                        root(_Root.vcsRoots.JdkGradlePlugins_HttpsGithubComBreskebyJdkGradlePluginsGit)
                        buildDefaultBranch = false
                        excludeDefaultBranchChanges = true
                    }
                }))
            }),
            Project({
                this.uuid = "${uuid}-buildAndTest"
                id = "JdkGradlePlugins_${branch}_buildAndTest"
                name = "Build & Test"
                buildType(JdkGradlePlugins_SanityCheck(branch))
            })
    )
})