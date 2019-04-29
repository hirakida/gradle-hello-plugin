package com.github.hirakida.gradle

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class HelloTask extends DefaultTask {

    @TaskAction
    def exec() {
        if (project.hello.debug) {
            println 'Start TaskAction.'
        }

        println "Hello, ${project.hello.message}"

        if (project.hello.debug) {
            println 'End TaskAction.'
        }
    }
}
