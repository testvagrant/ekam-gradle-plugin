package com.testvagrant.ekam.gradle.tasks.cucumber

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.JavaExec
import org.gradle.api.tasks.TaskAction

class CucumberTask extends DefaultTask {

    @TaskAction
    def run() {
        project.javaexec {
            main = "io.cucumber.core.cli.Main"
            List<String> args = this.getArgs()
            args.addAll(["--glue", "com.testvagrant.ekamExamples.mobile.steps"])
            classpath = sourceSets.test.runtimeClasspath
            systemProperties = [
                    config: System.getProperty("config", "default"),
                    tags  : System.getProperty("tags", "")
            ]
            ignoreExitValue = true
        }
    }

    def getArgs() {
        List<String> args = ["-p", "pretty",
                             "-p", ("json:${project.buildDir}/cucumber/cucumber-report.json"),
                             "-p", "timeline:${project.buildDir}/cucumber/timeline/",
                             "-t", System.getProperty("tags", ""),
                             "-p", "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm",
                             "--threads", System.getProperty("sessions", "1")]
        return args
    }
}
