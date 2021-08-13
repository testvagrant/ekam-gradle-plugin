package com.testvagrant.ekam.gradle.tasks

import org.gradle.api.tasks.TaskAction
import org.gradle.api.tasks.testing.Test

class ApiTask extends TestNgTask {
    @TaskAction
    def run() {
        super.run();
    }

    def filters() {
        filter {
            excludeTestsMatching "*.mobile.*"
            excludeTestsMatching "*.web.*"
            excludeTestsMatching "*.db.*"
        }
    }

    @Override
    String type() {
        return System.getProperty("api.tag", "api")
    }
}
