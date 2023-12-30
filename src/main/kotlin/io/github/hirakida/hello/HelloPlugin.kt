package io.github.hirakida.hello

import org.gradle.api.Plugin
import org.gradle.api.Project

class HelloPlugin : Plugin<Project> {
    companion object {
        const val TASK_NAME = "hello"
        const val EXTENSION_NAME = "hello"
    }

    override fun apply(project: Project) {
        project.extensions.create(EXTENSION_NAME, HelloExtension::class.java)
        project.tasks.create(TASK_NAME, HelloTask::class.java)
    }
}
