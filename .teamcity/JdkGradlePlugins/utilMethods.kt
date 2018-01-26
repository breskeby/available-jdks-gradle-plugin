import _Root.vcsRoots.JdkGradlePluginsVcsRootMaster
import _Root.vcsRoots.JdkGradlePluginsVcsRootRelease
import jetbrains.buildServer.configs.kotlin.v2017_2.vcs.GitVcsRoot

fun isReleaseOrMaster(vcsRoot: GitVcsRoot): Boolean =
        vcsRoot == JdkGradlePluginsVcsRootRelease || vcsRoot == JdkGradlePluginsVcsRootMaster
