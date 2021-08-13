package com.testvagrant.ekam.gradle.tasks

import org.gradle.api.tasks.TaskAction

class DBTask extends TestNgTask {

    @TaskAction
    def run() {
        super.run();
    }

    def filters() {
        filter {
            excludeTestsMatching "*.web.*"
            excludeTestsMatching "*.api.*"
            excludeTestsMatching "*.mobile.*"
        }
    }

    @Override
    String type() {
        return System.getProperty("db.tag", "db")
    }
}
