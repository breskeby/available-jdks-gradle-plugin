package JdkGradlePlugins.buildTypes

import jetbrains.buildServer.configs.kotlin.v2017_2.BuildType
import jetbrains.buildServer.configs.kotlin.v2017_2.triggers.vcs

class JdkGradlePlugins_Stage_Trigger_BT(uuid: String, branch: String, config: (bt:BuildType) -> kotlin.Unit) : BuildType({
    this.uuid = uuid
    this.id = "JdkGradlePlugins_BT_${branch}"
    this.name = "JdkGradlePlugins${branch}"

    config.invoke(this);

    triggers {
        vcs {
            triggerRules = """
                +:refs/heads/
                +:refs/(pull/*/head)
            """.trimIndent()
        }
    }
})
