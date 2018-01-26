package JdkGradlePlugins.projects

import JdkGradlePlugins.buildTypes.JdkGradlePlugins_SanityCheck
import JdkGradlePlugins.buildTypes.JdkGradlePlugins_Stage_Trigger_BT
import isReleaseOrMaster
import jetbrains.buildServer.configs.kotlin.v2017_2.Project
import jetbrains.buildServer.configs.kotlin.v2017_2.vcs.GitVcsRoot


class BranchProject(branch: String, vcsRoot: GitVcsRoot, uuid: String) : DotcomProject({
    this.uuid = uuid
    id = "JdkGradlePlugins_$branch"
    parentId = "JdkGradlePlugins"
    name = branch

    val sanityBt = JdkGradlePlugins_SanityCheck(branch, vcsRoot)

    subProjects(
            Project({
                this.uuid = "${uuid}-stages"
                id = "JdkGradlePlugins_${branch}_Stages"
                name = "Stages"
                buildType(JdkGradlePlugins_Stage_Trigger_BT(uuid + "_$branch", branch, {
                    it.vcs {
                        root(vcsRoot)
                        buildDefaultBranch = isReleaseOrMaster(vcsRoot)
                        excludeDefaultBranchChanges = isReleaseOrMaster(vcsRoot)
                    }
                    it.dependencies.dependency(sanityBt, {})
                }))
            }),
            Project({
                this.uuid = "${uuid}-buildAndTest"
                id = "JdkGradlePlugins_${branch}_buildAndTest"
                name = "Build & Test"
                buildType(sanityBt)
            })
    )
})
