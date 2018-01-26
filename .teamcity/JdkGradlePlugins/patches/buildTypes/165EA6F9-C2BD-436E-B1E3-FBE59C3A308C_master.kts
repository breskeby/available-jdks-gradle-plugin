package JdkGradlePlugins.patches.buildTypes

import jetbrains.buildServer.configs.kotlin.v2017_2.*
import jetbrains.buildServer.configs.kotlin.v2017_2.triggers.VcsTrigger
import jetbrains.buildServer.configs.kotlin.v2017_2.triggers.vcs
import jetbrains.buildServer.configs.kotlin.v2017_2.ui.*

/*
This patch script was generated by TeamCity on settings change in UI.
To apply the patch, change the buildType with uuid = '165EA6F9-C2BD-436E-B1E3-FBE59C3A308C_master' (id = 'JdkGradlePlugins_STAGE_BT_TRIGGER_master')
accordingly and delete the patch script.
*/
changeBuildType("165EA6F9-C2BD-436E-B1E3-FBE59C3A308C_master") {
    triggers {
        val trigger1 = find<VcsTrigger> {
            vcs {
                triggerRules = """
                    +:refs/heads/*
                    +:refs/(pull/*/head)
                """.trimIndent()
            }
        }
        trigger1.apply {
            triggerRules = "+:master"
            branchFilter = "+:master"
        }
    }
}
