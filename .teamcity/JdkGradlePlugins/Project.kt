package JdkGradlePlugins

import JdkGradlePlugins.projects.BranchProject
import _Root.vcsRoots.JdkGradlePluginsVcsRootMaster
import _Root.vcsRoots.JdkGradlePluginsVcsRootRelease
import jetbrains.buildServer.configs.kotlin.v2017_2.BuildType
import jetbrains.buildServer.configs.kotlin.v2017_2.Project

object Project : Project({
    uuid = "2eb20e0c-1e8b-4661-9d13-3e86e345f2ed"
    id = "JdkGradlePlugins"
    parentId = "_Root"
    name = "Jdk Gradle Plugins"

    val masterBranchProject = BranchProject.new("master", JdkGradlePluginsVcsRootMaster, "165EA6F9-C2BD-436E-B1E3-FBE59C3A308C")
    val releaseBranchProject = BranchProject.new("release", JdkGradlePluginsVcsRootRelease, "C8937837-F200-4C21-8AD5-7C5484BC93AB")

    val promotionProject = Project({
        this.name = "promotion"
        this.id = "JdkGradlePlugins_Promotion"
        this.parentId = "JdkGradlePlugins"
        this.uuid = "4E5F7ED9-FF95-4B6C-878C-EFF10F18EB14"

        subProject(Project({
            this.name = "development"
            this.id = "JdkGradlePlugins_Promotion_Production"
            this.parentId = "JdkGradlePlugins_Production"
            this.uuid = "C1FCE5A7-D226-4797-929A-887073F8EDFA"

            buildType(BuildType({
                this.uuid = "B35EB536-21CC-4091-91C8-3C9D0C9487F1"
                this.id = "JdkGradlePlugins_Promotion_production_deploy"
                this.name = "Deploy"
                this.dependencies.dependency(releaseBranchProject.triggerBt, { snapshot {} })
            }))
        }))
    })

    subProjects(
            masterBranchProject,
            releaseBranchProject,
            promotionProject
    )

})
