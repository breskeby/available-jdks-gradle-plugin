package com.breskeby.gradle.env

import org.gradle.api.Task
import org.gradle.internal.jvm.Jvm

class AvailableJdks {

    private static final String JDK6_ENV_VAR = "JDK6"
    private static final List<File> KNOWN_JDKS = [
            "/Library/Java/JavaVirtualMachines/1.6.0.jdk/Contents/Home",
            "/System/Library/Java/JavaVirtualMachines/1.6.0.jdk/Contents/Home"
    ].collect { new File(it) }

    private static Map<String, String> env

    static void init(Map<String, String> env) {
        this.env = env
    }

    static File getJdk6HomeFor(Task task) {
        String jdk6Home = env.get(JDK6_ENV_VAR)
        if (jdk6Home != null) {
            File jdk6HomeFile = new File(jdk6Home)
            if (jdk6HomeFile.directory) {
                jdk6HomeFile
            } else {
                throw new IllegalStateException("$JDK6_ENV_VAR value '$jdk6HomeFile.absolutePath' does not exist")
            }
        } else {
            File known = KNOWN_JDKS.find { it.directory }
            if (known == null) {
                throw new IllegalStateException(
                        "Cannot run ${task.path} without a JDK 6.\n" +
                                "Set a '$JDK6_ENV_VAR' env var with the location of a JDK 6 install, or install this if on Mac OS…\n" +
                                "https://support.apple.com/kb/DL1572"
                )
            } else {
                known
            }
        }
    }

    static File getJdk6JavacFor(Task task) {
        new File(getJdk6HomeFor(task), "bin/javac")
    }

    static File getJdk6JavaFor(Task task) {
        new File(getJdk6HomeFor(task), "bin/java")
    }

    private static final List<String> RUNTIME_JAR_PATHS = ['jre/lib/rt.jar', 'bundle/Classes/classes.jar']

    static File getJdk6RuntimeJarFor(Task task) {
        File jdkHome = getJdk6HomeFor(task)
        for (String jarPath : RUNTIME_JAR_PATHS) {
            File runtimeJar = new File(jdkHome, jarPath)
            if (runtimeJar.exists()) {
                return runtimeJar
            }
        }
        throw new IllegalStateException("Could not find JDK6 runtime jar. Looked in:"
                + RUNTIME_JAR_PATHS.collect { "\n\t$it" })
    }

    static File getBuildJavap() {
        def javap = Jvm.current().getExecutable("javap")
        assert javap.exists()
        javap
    }

}
