package com.testvagrant.ekam.gradle.plugins

import com.testvagrant.ekam.gradle.tasks.ApiTask
import com.testvagrant.ekam.gradle.tasks.WebTask
import org.gradle.api.Plugin
import org.gradle.api.Project

class EkamGradlePlugin implements Plugin<Project> {
    def group = "ekam"
    @Override
    void apply(Project project) {
        project.getTasks().create("runWebTests", WebTask.class).setGroup(group);
        project.getTasks().create("runApiTests", ApiTask.class).setGroup(group);
    }
}
