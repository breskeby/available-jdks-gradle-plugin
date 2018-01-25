package _Root

import _Root.vcsRoots.*
import _Root.vcsRoots.JdkGradlePlugins_HttpsGithubComBreskebyJdkGradlePluginsGit
import jetbrains.buildServer.configs.kotlin.v2017_2.*
import jetbrains.buildServer.configs.kotlin.v2017_2.Project
import jetbrains.buildServer.configs.kotlin.v2017_2.projectFeatures.VersionedSettings
import jetbrains.buildServer.configs.kotlin.v2017_2.projectFeatures.versionedSettings

object Project : Project({
    uuid = "3fbba039-811f-4627-b817-7a6268f5e812"
    id = "_Root"
    name = "<Root project>"
    description = "Contains all other projects"

    vcsRoot(Gradle_Branches_VersionedSettings)
    vcsRoot(Gradle_Master)
    vcsRoot(JdkGradlePlugins_HttpsGithubComBreskebyJdkGradlePluginsGit)

    params {
        param("env.BUILD_ID", "%teamcity.build.id%")
        param("env.BUILD_SERVER_URL", "%teamcity.serverUrl%")
        param("env.BUILD_TYPE_ID", "%system.teamcity.buildType.id%")
        param("env.BUILD_URL", "%teamcity.serverUrl%/viewLog.html?buildId=%teamcity.build.id%")
        param("env.CI", "1")
        param("env.JAVA_HOME", "%linux.java8.oracle.64bit%")
        password("github.ci.oauth.token", "credentialsJSON:719f8f2d-e4b5-4df1-aadc-6411ce1d33b0", label = "github.ci.oauth.token")
        password("gradle.cache.child.password", "credentialsJSON:da4ffe98-88e6-4a53-b6a6-3cdccc8fd8d5", display = ParameterDisplay.HIDDEN)
        password("gradle.cache.child.url", "credentialsJSON:033a0c34-6e12-44bd-910d-f87a98cb2685", display = ParameterDisplay.HIDDEN)
        param("gradle.cache.child.username", "gradle")
        password("gradle.cache.parent.password", "credentialsJSON:da4ffe98-88e6-4a53-b6a6-3cdccc8fd8d5", display = ParameterDisplay.HIDDEN)
        password("gradle.cache.parent.url", "credentialsJSON:85c50f5b-e5af-453f-bd86-49911fd91b37", display = ParameterDisplay.HIDDEN)
        param("gradle.cache.parent.username", "gradle")
        password("gradle.cache.remote.password", "credentialsJSON:da4ffe98-88e6-4a53-b6a6-3cdccc8fd8d5")
        password("gradle.cache.remote.url", "credentialsJSON:85c50f5b-e5af-453f-bd86-49911fd91b37", display = ParameterDisplay.HIDDEN)
        param("gradle.cache.remote.username", "gradle")
        param("linux.java10.openjdk.64bit", "/opt/jdk/open-jdk-10")
        param("linux.java5.sun.32bit", "/opt/jdk/sun-jdk-5")
        param("linux.java6.ibm.64bit", "/opt/jdk/ibm-jdk-6")
        param("linux.java6.sun.64bit", "/opt/jdk/sun-jdk-6")
        param("linux.java7.ibm.64bit", "/opt/jdk/ibm-jdk-7")
        param("linux.java7.oracle.64bit", "/opt/jdk/oracle-jdk-7")
        param("linux.java8.oracle.64bit", "/Users/Rene/.sdkman/candidates/java/8u152-zulu")
        param("linux.java9.oracle.64bit", "/opt/jdk/oracle-jdk-9")
        param("linux.jdk.for.gradle.compile", "/opt/jdk/jdk-for-gradle-compile")
        param("macos.java8.oracle.64bit", "/Library/Java/JavaVirtualMachines/jdk1.8.0_152.jdk/Contents/Home")
        password("performance.db.password.tcagent", "credentialsJSON:b9a115c4-c1c7-4e12-88c7-cf729920efa7", display = ParameterDisplay.HIDDEN)
        param("system.locks.readLock.linux1ExclusiveUse", "")
        param("teamcity.agent.filecache.publishing.disabled", "true")
        param("teamcity.agent.filecache.size.limit.bytes", "524288000")
        password("teamcity.password.restbot", "credentialsJSON:368a9ef1-9664-4ed2-81ac-90f16c032ef1", display = ParameterDisplay.HIDDEN)
        param("teamcity.username.restbot", "TeamcityRestBot")
        param("windows.java5.sun.32bit", """C:\Program Files (x86)\Java\jdk1.5.0_22""")
        param("windows.java6.sun.64bit", """C:\program files\java\jdk1.6""")
        param("windows.java7.oracle.64bit", """C:\Program Files\Java\jdk1.7""")
        param("windows.java8.oracle.64bit", """C:\Program Files\Java\jdk1.8""")
    }

    features {
        versionedSettings {
            id = "PROJECT_EXT_1"
            mode = VersionedSettings.Mode.ENABLED
            buildSettingsMode = VersionedSettings.BuildSettingsMode.USE_CURRENT_SETTINGS
            rootExtId = JdkGradlePlugins_HttpsGithubComBreskebyJdkGradlePluginsGit.id
            showChanges = false
            settingsFormat = VersionedSettings.Format.KOTLIN
            storeSecureParamsOutsideOfVcs = true
        }
        feature {
            id = "PROJECT_EXT_24"
            type = "OAuthProvider"
            param("clientId", "8c10a0e574f3dbb300cb")
            param("secure:clientSecret", "credentialsJSON:3b655abb-2f6a-4b0b-8a68-f9bfa62a63d6")
            param("displayName", "GitHub.com")
            param("gitHubUrl", "https://github.com/")
            param("providerType", "GitHub")
        }
        feature {
            id = "PROJECT_EXT_80"
            type = "CloudIntegration"
            param("enabled", "false")
        }
        feature {
            id = "PROJECT_EXT_82"
            type = "CloudImage"
            param("profileFeatureId", "PROJECT_EXT_81")
            param("key-pair-name", "ssh-lari")
            param("security-group-ids", "sg-cf813fa6,")
            param("profileId", "amazon-1")
            param("agent_pool_id", "0")
            param("securityGroupsUI", "sg-cf813fa6")
            param("subnet-id", "subnet-5d4fa934")
            param("instance-type", "c3.xlarge")
            param("avilability-zone", "")
            param("source-id", "ami-765c586b")
        }
        feature {
            id = "amazon-1"
            type = "CloudProfile"
            param("secure:access-id", "credentialsJSON:7bbd1ebd-f1a1-414a-abc5-65a1d926655f")
            param("description", "Frankfurt build farm")
            param("cloud-code", "amazon")
            param("terminate-after-build", "false")
            param("endpoint-url", "ec2.eu-central-1.amazonaws.com")
            param("enabled", "true")
            param("max-running-instances", "1")
            param("agentPushPreset", "")
            param("profileId", "amazon-1")
            param("name", "ec2-agent-eu-central-1")
            param("secure:secret-key", "credentialsJSON:20d01ebe-6067-4814-a86b-cb3f8ceaee38")
            param("terminate-idle-time", "30")
            param("not-checked", "")
        }
    }

    cleanup {
        all(days = 180)
        history(days = 28)
        artifacts(days = 28)
        preventDependencyCleanup = false
    }
})
