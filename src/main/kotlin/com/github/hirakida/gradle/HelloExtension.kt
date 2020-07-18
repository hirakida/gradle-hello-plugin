package com.github.hirakida.gradle

import org.gradle.api.tasks.Input

open class HelloExtension {
    @get:Input
    var message: String = "Gradle Plugin!"

    @get:Input
    var debug: Boolean = false
}
