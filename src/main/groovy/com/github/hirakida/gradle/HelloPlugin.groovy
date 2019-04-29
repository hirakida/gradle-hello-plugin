package com.github.hirakida.gradle

import org.gradle.api.Plugin
import org.gradle.api.Project

class HelloPlugin implements Plugin<Project> {
    public static final String TASK_NAME = 'hello'
    public static final String EXTENSION_NAME = 'hello'

    @Override
    void apply(Project project) {
        project.extensions.create(EXTENSION_NAME, HelloExtension)
        project.tasks.create(TASK_NAME, HelloTask)
    }
}
