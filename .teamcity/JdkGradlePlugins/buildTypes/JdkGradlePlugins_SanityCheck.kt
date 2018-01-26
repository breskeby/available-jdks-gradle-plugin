package JdkGradlePlugins.buildTypes

import jetbrains.buildServer.configs.kotlin.v2017_2.BuildType
import jetbrains.buildServer.configs.kotlin.v2017_2.buildSteps.gradle

class JdkGradlePlugins_SanityCheck(branch: String) : BuildType({
    uuid = "39a450f0-cdf6-465e-a9bc-5109d30ba798-$branch"
    id = "JdkGradlePlugins_${branch}_buildAndTest_SanityCheck"
    name = "SanityCheck"

    params {
        param("env. JAVA_HOME", "/Users/Rene/.sdkman/candidates/java/8u152-zulu")
    }

    vcs {
        root(_Root.vcsRoots.JdkGradlePlugins_HttpsGithubComBreskebyJdkGradlePluginsGit)

        buildDefaultBranch = false
    }

    steps {
        gradle {
            tasks = "clean assemble"
            useGradleWrapper = true
        }
    }
})
