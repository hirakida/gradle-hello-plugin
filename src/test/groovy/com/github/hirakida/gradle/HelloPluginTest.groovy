package com.github.hirakida.gradle

import org.gradle.testkit.runner.BuildResult
import org.gradle.testkit.runner.GradleRunner
import org.gradle.testkit.runner.TaskOutcome
import spock.lang.Specification
import spock.lang.TempDir
import spock.lang.Unroll

/**
 * https://docs.gradle.org/8.5/userguide/test_kit.html
 */
class HelloPluginTest extends Specification {
    private static final List<String> GRADLE_VERSIONS = ['7.2', '8.5']
    @TempDir
    File testProjectDir
    File settingsFile
    File buildFile

    def setup() {
        settingsFile = new File(testProjectDir, 'settings.gradle')
        buildFile = new File(testProjectDir, 'build.gradle')
    }

    @Unroll
    def "HelloPlugin default message [#gradleVersion]"() {
        given:
        settingsFile << "rootProject.name = 'hello1'"
        buildFile << """
            plugins {
                id 'com.github.hirakida.hello' version '0.0.7'
            }
        """

        when:
        BuildResult result = GradleRunner.create()
                .withGradleVersion(gradleVersion)
                .withProjectDir(testProjectDir)
                .withArguments('hello')
                .build()

        then:
        result.task(":hello").outcome == TaskOutcome.SUCCESS
        result.output.contains('Hello, Gradle Plugin!')

        where:
        gradleVersion << GRADLE_VERSIONS
    }

    @Unroll
    def "HelloPlugin custom message [#gradleVersion]"() {
        given:
        settingsFile << "rootProject.name = 'hello2'"
        buildFile << """
            plugins {
                id 'com.github.hirakida.hello' version '0.0.7'
            }
            hello {
                message = 'Hello!'
            }
        """

        when:
        BuildResult result = GradleRunner.create()
                .withGradleVersion(gradleVersion)
                .withProjectDir(testProjectDir)
                .withArguments('hello')
                .build()

        then:
        result.task(":hello").outcome == TaskOutcome.SUCCESS
        result.output.contains('Hello, Hello!')

        where:
        gradleVersion << GRADLE_VERSIONS
    }
}
