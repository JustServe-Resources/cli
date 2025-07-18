package org.justserve

import io.micronaut.configuration.picocli.PicocliRunner
import io.micronaut.context.ApplicationContext
import io.micronaut.context.annotation.Value
import io.micronaut.context.env.Environment
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

import java.util.regex.Pattern

@MicronautTest()
class FulcrumCommandSpec extends Specification {

    @Shared
    Pattern cliVersion

    @Shared
    String justServeUrl

    @Shared
    Pattern blankRegex = Pattern.compile "^\\s*\$"

    @Shared
    Pattern successRegex = Pattern.compile("^\\w+\\s{1,2}\$")

    @Shared
    Pattern errorRegex = Pattern.compile "^received an unexpected response from JustServe: \\d+ \\(.*\\)\\s*\$"

    @Shared
    Pattern tokenNotSetRegex = Pattern.compile "The Authentication token is not assigned as an " +
            "environment variable\\. Please define the environment variable \"JUSTSERVE_TOKEN\" and try again\\.\\s*\$"


    def setupSpec() {
        justServeUrl = System.getenv("JUSTSERVE_URL") ?: "https://www.justserve.org"
        def props = new Properties()
        new File('gradle.properties').withInputStream { stream ->
            props.load(stream)
        }
        cliVersion = Pattern.compile("^" + props.getProperty('justserveCliVersion') + "\\s*\$")
    }

    @Unroll("command with args: #args produces expected output when auth is set to #auth")
    def "commands should behave correctly when JUSTSERVE_TOKEN is unset"() {
        when:
        if (null != System.getenv("JUSTSERVE_TOKEN")) {
            throw new IllegalStateException("JUSTSERVE_TOKEN is set. Do not define this variable in testing.")
        }
        ApplicationContext ctx
        if (auth) {
            ctx = ApplicationContext.builder()
                    .environments(Environment.CLI, Environment.TEST)
                    .properties([
                            "justserve.token": System.getenv("TEST_TOKEN"),
                            "micronaut.http.services.justserve.url"  : justServeUrl
                    ])
                    .build()
                    .start()
        } else {
            ctx = ApplicationContext
                    .builder()
                    .environments(Environment.CLI, Environment.TEST)
                    .environmentVariableExcludes("JUSTSERVE_TOKEN")
                    .properties(["micronaut.http.services.justserve.url": justServeUrl])
                    .build()
                    .start()
        }

        and:
        def (outputStream, errorStream) = executeCommand(ctx, args)

        then:
        verifyAll {
            outputStream.toString().matches(expectedOutputValue)
            errorStream.toString().matches(expectedErrorOutput)
        }

        and:
        ctx.stop()

        where:
        args                                           | expectedOutputValue | expectedErrorOutput | auth  | _
        new String[]{"-v"}                             | cliVersion          | blankRegex          | false | _
        new String[]{"--version"}                      | cliVersion          | blankRegex          | false | _
        new String[]{"version"}                        | cliVersion          | blankRegex          | false | _
        new String[]{"-e", "jimmy@justserve.org"}      | blankRegex          | tokenNotSetRegex    | false | _
        new String[]{"--email", "jimmy@justserve.org"} | blankRegex          | tokenNotSetRegex    | false | _
        new String[]{"-e", "notanemail@mail.moc"}      | blankRegex          | tokenNotSetRegex    | false | _
        new String[]{"--email", "notanemail@mail.moc"} | blankRegex          | tokenNotSetRegex    | false | _
        new String[]{"-v"}                             | cliVersion          | blankRegex          | true  | _
        new String[]{"--version"}                      | cliVersion          | blankRegex          | true  | _
        new String[]{"version"}                        | cliVersion          | blankRegex          | true  | _
        new String[]{"-e", "jimmy@justserve.org"}      | successRegex        | blankRegex          | true  | _
        new String[]{"--email", "jimmy@justserve.org"} | successRegex        | blankRegex          | true  | _
        new String[]{"-e", "notanemail@mail.moc"}      | blankRegex          | errorRegex          | true  | _
        new String[]{"--email", "notanemail@mail.moc"} | blankRegex          | errorRegex          | true  | _
    }

    /**
     * Executes a command with the given arguments and a specific application context,
     * capturing stdout and stderr.
     *
     * @param ctx The application context to use for running the command.
     * @param args The arguments to pass to the command.
     * @return An array containing the captured stdout (at index 0) and stderr (at index 1)
     *         as String representations of the output streams.
     */

    String[] executeCommand(ApplicationContext ctx, String... args) {
        OutputStream out = new ByteArrayOutputStream()
        OutputStream err = new ByteArrayOutputStream()
        System.setOut(new PrintStream(out))
        System.setErr(new PrintStream(err))
        PicocliRunner.run(FulcrumCommand.class, ctx, args)
        return new String[]{out, err}
    }
}
