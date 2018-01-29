package JdkGradlePlugins.buildTypes

import isReleaseOrMaster
import jetbrains.buildServer.configs.kotlin.v2017_2.BuildType
import jetbrains.buildServer.configs.kotlin.v2017_2.buildSteps.gradle
import jetbrains.buildServer.configs.kotlin.v2017_2.vcs.GitVcsRoot

class JdkGradlePlugins_SanityCheck(branch: String, vcsRoot: GitVcsRoot) : BuildType({
    uuid = "39a450f0-cdf6-465e-a9bc-5109d30ba798-$branch"
    id = "JdkGradlePlugins_${branch}_buildAndTest_SanityCheck"
    name = "SanityCheck"

    params {
        param("env. JAVA_HOME", "/Users/Rene/.sdkman/candidates/java/8u152-zulu")
    }

    vcs {
        root(vcsRoot)
        buildDefaultBranch = isReleaseOrMaster(vcsRoot)
        excludeDefaultBranchChanges = isReleaseOrMaster(vcsRoot)

    }

    steps {
        gradle {
            buildFile = "build.gradle" //
            tasks = "clean assemble"
            useGradleWrapper = true
        }
    }
})
