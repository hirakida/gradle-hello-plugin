package com.github.hirakida.gradle

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class HelloTask extends DefaultTask {

    public static final String TASK_NAME = 'hello'

    @TaskAction
    def exec() {
        println "Hello, ${project.hello.message}"
    }
}
