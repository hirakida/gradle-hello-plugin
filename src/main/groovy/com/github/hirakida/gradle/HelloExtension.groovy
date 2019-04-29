package com.github.hirakida.gradle

import org.gradle.api.tasks.Input

class HelloExtension {

    @Input
    String message = 'Gradle Plugin!'

    @Input
    boolean debug
}
