package JdkGradlePlugins.projects

import jetbrains.buildServer.configs.kotlin.v2017_2.Project


open class DotcomProject(init: Project.() -> Unit) : Project(init) {
    companion object {
    }
}