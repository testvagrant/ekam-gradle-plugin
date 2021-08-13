package com.testvagrant.ekam.gradle.tasks

import org.gradle.api.tasks.testing.Test

abstract class TestNgTask extends Test {
    TestNgTask() {
        outputs.upToDateWhen {false}
    }

    def run() {
        filters()
        testngConfig()
        executeTests()
    }

    def testngConfig() {
        useTestNG {
            parallel = System.getProperty("parallel", "methods")
            threadCount Integer.parseInt(System.getProperty("sessions", "1"))
            includeGroups System.getProperty("tags", type())
            testLogging.showStandardStreams = true
            useDefaultListeners true
            outputDirectory = project.file("${project.buildDir}/" + System.getProperty('tags', 'NONE'))
        }
    }

    abstract def filters();

    abstract String type();
}
