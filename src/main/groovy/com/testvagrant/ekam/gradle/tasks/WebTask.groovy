package com.testvagrant.ekam.gradle.tasks

import org.gradle.api.tasks.TaskAction
import org.gradle.api.tasks.testing.Test

class WebTask extends TestNgTask {

    @TaskAction
    def run() {
        super.run();
    }

    def filters() {
        filter {
            excludeTestsMatching "*.mobile.*"
            excludeTestsMatching "*.api.*"
            excludeTestsMatching "*.db.*"
        }
    }

    @Override
    String type() {
        return System.getProperty("web.tag", "web")
    }
}
