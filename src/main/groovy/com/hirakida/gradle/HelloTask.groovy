package com.hirakida.gradle

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class HelloTask extends DefaultTask {

    public static final String NAME = 'hello'

    @TaskAction
    def exec() {
        println "${project.hello.greeting}, ${project.hello.message}"
    }
}
