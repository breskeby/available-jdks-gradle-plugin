package JdkGradlePlugins

import JdkGradlePlugins.buildTypes.JdkGradlePlugins_FuncTest
import JdkGradlePlugins.buildTypes.JdkGradlePlugins_UnitTest
import JdkGradlePlugins.projects.BranchProject
import _Root.vcsRoots.JdkGradlePluginsVcsRootMaster
import _Root.vcsRoots.JdkGradlePluginsVcsRootRelease
import jetbrains.buildServer.configs.kotlin.v2017_2.Project

object Project : Project({
    uuid = "2eb20e0c-1e8b-4661-9d13-3e86e345f2ed"
    id = "JdkGradlePlugins"
    parentId = "_Root"
    name = "Jdk Gradle Plugins"

    buildType(JdkGradlePlugins_FuncTest)
    buildType(JdkGradlePlugins_UnitTest)

    subProjects(
            BranchProject("master", JdkGradlePluginsVcsRootMaster, "165EA6F9-C2BD-436E-B1E3-FBE59C3A308C"),
            BranchProject("release",JdkGradlePluginsVcsRootRelease, "C8937837-F200-4C21-8AD5-7C5484BC93AB")
    )

})
