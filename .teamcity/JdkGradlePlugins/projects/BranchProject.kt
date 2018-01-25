package JdkGradlePlugins.projects

import JdkGradlePlugins.buildTypes.JdkGradlePlugins_Branch
import jetbrains.buildServer.configs.kotlin.v2017_2.Project


class BranchProject(branch: String, uuid: String) : Project({
    this.uuid = uuid
    id = "JdkGradlePlugins_$branch"
    parentId = "JdkGradlePlugins"
    name = branch

    subProjects(Project({
            this.uuid = "${uuid}-stages"
            id = "JdkGradlePlugins_${branch}_Stages"
            name = "Stages"
            buildType(JdkGradlePlugins_Branch(uuid = uuid + "_$branch", branch = branch))
        })
    )
})