package JdkGradlePlugins.projects

import JdkGradlePlugins.buildTypes.JdkGradlePlugins_SanityCheck
import JdkGradlePlugins.buildTypes.JdkGradlePlugins_Stage_Trigger_BT
import isReleaseOrMaster
import jetbrains.buildServer.configs.kotlin.v2017_2.Project
import jetbrains.buildServer.configs.kotlin.v2017_2.vcs.GitVcsRoot


class BranchProject private constructor(branch: String, vcsRoot: GitVcsRoot, uuid: String) : DotcomProject({
    this.uuid = uuid
    this.id = "JdkGradlePlugins_$branch"
    this.parentId = "JdkGradlePlugins"
    this.name = branch

}) {
    val sanityBt = JdkGradlePlugins_SanityCheck(branch, vcsRoot)
    val triggerBt = JdkGradlePlugins_Stage_Trigger_BT(uuid + "_$branch", branch, {
        it.vcs {
            root(vcsRoot)
            buildDefaultBranch = isReleaseOrMaster(vcsRoot)
            excludeDefaultBranchChanges = isReleaseOrMaster(vcsRoot)
        }
        it.dependencies.dependency(sanityBt, { snapshot {} })

    })

    companion object {
        fun new(branch: String, vcsRoot: GitVcsRoot, uuid: String) : BranchProject {
            val branchProject = BranchProject(branch, vcsRoot, uuid)
            branchProject.subProjects(
                    Project({
                        this.uuid = "${uuid}-stages"
                        id = "JdkGradlePlugins_${branch}_Stages"
                        name = "Stages"
                        buildType(branchProject.triggerBt)
                    }),
                    Project({
                        this.uuid = "${uuid}-buildAndTest"
                        id = "JdkGradlePlugins_${branch}_buildAndTest"
                        name = "Build & Test"
                        buildType(branchProject.sanityBt)
                    })
            )
            return branchProject
        }
    }

}
