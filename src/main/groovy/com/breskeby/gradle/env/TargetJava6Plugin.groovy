package com.breskeby.gradle.env

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.internal.file.collections.SimpleFileCollection
import org.gradle.api.plugins.JavaPlugin
import org.gradle.api.plugins.quality.CheckstyleExtension
import org.gradle.api.plugins.quality.CheckstylePlugin
import org.gradle.api.tasks.compile.AbstractCompile
import org.gradle.api.tasks.compile.CompileOptions
import org.gradle.api.tasks.compile.GroovyCompile
import org.gradle.api.tasks.compile.JavaCompile
import org.gradle.api.tasks.testing.Test
import org.gradle.plugins.ide.idea.model.IdeaLanguageLevel
import org.gradle.plugins.ide.idea.model.IdeaModule

class TargetJava6Plugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        project.plugins.withType(JavaPlugin) {
            project.sourceCompatibility = '1.6'
            project.targetCompatibility = '1.6'

            (project.idea.module as IdeaModule).with {
                languageLevel = new IdeaLanguageLevel("1.6")
            }

            [
                    project.tasks.withType(JavaCompile),
                    project.tasks.withType(GroovyCompile),
                    project.tasks.withType(Test)
            ]*.all {
                ext.useJava6 = true
            }

            project.gradle.taskGraph.whenReady { taskGraph ->
                [project.tasks.withType(JavaCompile), project.tasks.withType(GroovyCompile)].flatten().each { AbstractCompile task ->
                    if (task.ext.useJava6 && taskGraph.hasTask(task)) {
                        task.with {
                            sourceCompatibility = '1.6'
                            targetCompatibility = '1.6'
                        }
                        (task.options as CompileOptions).with {
                            fork = true
                            // SimpleFileCollection to workaround https://github.com/gradle/gradle/issues/3098
                            bootstrapClasspath = new SimpleFileCollection(project.files(AvailableJdks.getJdk6RuntimeFor(task)).files)
                        }
                    }
                }

                project.tasks.withType(Test) { testTask ->
                    if (testTask.ext.useJava6 && taskGraph.hasTask(testTask)) {
                        testTask.executable = AvailableJdks.getJdk6JavaFor(testTask).absolutePath
                    }
                }
            }
        }

        project.plugins.withType(CheckstylePlugin) {
            project.extensions.getByType(CheckstyleExtension).toolVersion = "6.1"
        }
    }

}
