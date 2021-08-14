// ../.gradlew hello

plugins {
    id("com.github.hirakida.hello") version "0.0.7"
}

hello {
    message = "gradle-hello-plugin!"
    debug = true
}
