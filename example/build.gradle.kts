// ../.gradlew hello

plugins {
    id("io.github.hirakida.hello") version "0.1.0"
}

hello {
    message = "gradle-hello-plugin!"
    debug = true
}
