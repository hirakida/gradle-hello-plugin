package com.github.hirakida.gradle

import org.gradle.api.Plugin
import org.gradle.api.Project

class HelloPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        project.extensions.create(HelloExtension.EXTENSION_NAME, HelloExtension)
        project.tasks.create(HelloTask.TASK_NAME, HelloTask)
    }
}
