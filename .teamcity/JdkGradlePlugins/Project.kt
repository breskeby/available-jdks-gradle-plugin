package JdkGradlePlugins

import JdkGradlePlugins.buildTypes.JdkGradlePlugins_Branch
import JdkGradlePlugins.buildTypes.JdkGradlePlugins_FuncTest
import JdkGradlePlugins.buildTypes.JdkGradlePlugins_SanityCheck
import JdkGradlePlugins.buildTypes.JdkGradlePlugins_UnitTest
import jetbrains.buildServer.configs.kotlin.v2017_2.Project

object Project : Project({
    uuid = "2eb20e0c-1e8b-4661-9d13-3e86e345f2ed"
    id = "JdkGradlePlugins"
    parentId = "_Root"
    name = "Jdk Gradle Plugins"

    buildType(JdkGradlePlugins_FuncTest)
    buildType(JdkGradlePlugins_SanityCheck)
    buildType(JdkGradlePlugins_UnitTest)

    subProjects(Project({
        uuid = "165EA6F9-C2BD-436E-B1E3-FBE59C3A308C"
        id = "JdkGradlePlugins_master"
        parentId = "JdkGradlePlugins"
        name = "Master"
        buildType(JdkGradlePlugins_Branch(uuid = "DC741F4C-D5B1-4429-A7CF-7FBC8BD9DCED", branch = "Master"))
    }), Project({
        uuid = "C8937837-F200-4C21-8AD5-7C5484BC93AB"
        id = "JdkGradlePlugins_release"
        parentId = "JdkGradlePlugins"
        name = "Release"

        buildType(JdkGradlePlugins_Branch(uuid = "E8671F2E-A8C3-4363-A510-0C1555515641", branch = "Release"))
    })
    )
})
