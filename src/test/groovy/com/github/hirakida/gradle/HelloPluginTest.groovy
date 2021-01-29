package com.github.hirakida.gradle

import org.gradle.testkit.runner.BuildResult
import org.gradle.testkit.runner.GradleRunner
import org.gradle.testkit.runner.TaskOutcome
import spock.lang.Specification
import spock.lang.Unroll

/**
 * https://docs.gradle.org/6.8.1/userguide/test_kit.html
 */
class HelloPluginTest extends Specification {
    private static final List<String> GRADLE_VERSIONS = ['6.3', '6.4', '6.5', '6.6', '6.7', '6.8']
    private static File projectDir

    def setupSpec() {
        ClassLoader classLoader = getClass().getClassLoader()
        projectDir = new File(classLoader.getResource("hello").getFile())
    }

    @Unroll
    def "HelloPlugin default message [Gradle #gradleVersion]"() {
        when:
        BuildResult result = GradleRunner.create()
                .withProjectDir(projectDir)
                .withArguments('hello', '-b', 'build1.gradle')
                .withPluginClasspath()
                .withGradleVersion(gradleVersion)
                .forwardStdOutput(new OutputStreamWriter(System.out))
                .forwardStdError(new OutputStreamWriter(System.err))
                .build()

        then:
        result.task(":hello").outcome == TaskOutcome.SUCCESS
        result.output.contains('Hello, Gradle Plugin!')

        where:
        gradleVersion << GRADLE_VERSIONS
    }

    @Unroll
    def "HelloPlugin custom message [Gradle #gradleVersion]"() {
        when:
        BuildResult result = GradleRunner.create()
                .withProjectDir(projectDir)
                .withArguments('hello', '-b', 'build2.gradle')
                .withPluginClasspath()
                .withGradleVersion(gradleVersion)
                .forwardStdOutput(new OutputStreamWriter(System.out))
                .forwardStdError(new OutputStreamWriter(System.err))
                .build()

        then:
        result.task(":hello").outcome == TaskOutcome.SUCCESS
        result.output.contains('Hello, Hello Plugin Test')

        where:
        gradleVersion << GRADLE_VERSIONS
    }
}
