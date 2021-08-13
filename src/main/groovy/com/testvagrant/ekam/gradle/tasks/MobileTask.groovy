package com.testvagrant.ekam.gradle.tasks

import org.gradle.api.tasks.TaskAction

class MobileTask extends TestNgTask {

    @TaskAction
    def run() {
        super.run();
    }

    def filters() {
        filter {
            excludeTestsMatching "*.web.*"
            excludeTestsMatching "*.api.*"
            excludeTestsMatching "*.db.*"
        }
    }

    @Override
    String type() {
        return System.getProperty("mobile.tag", "mobile")
    }
}
