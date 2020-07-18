package com.github.hirakida.gradle

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

open class HelloTask : DefaultTask() {
    @TaskAction
    fun exec() {
        val extension = project.extensions.getByType(HelloExtension::class.java)
        if (extension.debug) {
            print("Start TaskAction")
        }

        print("Hello, ${extension.message}")

        if (extension.debug) {
            print("End TaskAction")
        }
    }
}
