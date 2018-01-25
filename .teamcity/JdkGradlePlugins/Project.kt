package JdkGradlePlugins

import JdkGradlePlugins.buildTypes.*
import jetbrains.buildServer.configs.kotlin.v2017_2.*
import jetbrains.buildServer.configs.kotlin.v2017_2.Project

object Project : Project({
    uuid = "2eb20e0c-1e8b-4661-9d13-3e86e345f2ed"
    id = "JdkGradlePlugins"
    parentId = "_Root"
    name = "Jdk Gradle Plugins"

    buildType(JdkGradlePlugins_FuncTest)
    buildType(JdkGradlePlugins_SanityCheck)
    buildType(JdkGradlePlugins_UnitTest)
})
