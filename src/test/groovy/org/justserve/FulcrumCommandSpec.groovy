package org.justserve

import io.micronaut.configuration.picocli.PicocliRunner
import io.micronaut.context.ApplicationContext
import io.micronaut.context.env.Environment
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

import java.util.regex.Pattern

@MicronautTest
class FulcrumCommandSpec extends Specification {

    @Shared
    String cliVersion

    @Shared
    Pattern blankRegex = Pattern.compile "^\\s*\$"

    @Shared
    Pattern errorRegex = Pattern.compile "^received an unexpected response from JustServe: \\d+ \\(.*\\)\\s*\$"

    def setupSpec() {
        def props = new Properties()
        // Assumes tests are run from the project's root directory
        new File('gradle.properties').withInputStream { stream ->
            props.load(stream)
        }
        cliVersion = props.getProperty('justserveCliVersion')
    }

    @Unroll("command with args: #args prints version")
    def "version command should print the correct version"() {
        when:
        def (outputStream, errorStream) = executeCommand(args)

        then:
        // The version command typically prints a newline, so we trim the output
        outputStream.toString().trim() == cliVersion
        errorStream.toString().matches(blankRegex)

        where:
        args                      | _
        new String[]{"-v"}        | _
        new String[]{"--version"} | _
        new String[]{"version"}   | _

    }

    @Unroll("command with args: #args produces expected output")
    def "email option should produce expected output"() {
        when:
        def (outputStream, errorStream) = executeCommand(args)

        then:
        outputStream.toString().matches(expectedOutputValue)
        errorStream.toString().matches(expectedErrorOutput)

        where:
        args                                           | expectedOutputValue | expectedErrorOutput | _
        new String[]{'-e', 'jimmy@justserve.org'}      | ~/^\w+\s*$/         | blankRegex          | _
        new String[]{'--email', 'jimmy@justserve.org'} | ~/^\w+\s*$/         | blankRegex          | _
        new String[]{'-e', 'notanemail@mail.moc'}      | blankRegex          | errorRegex          | _
    }

    /**
     * Execute a command with the given arguments and return a pair of streams as stdout and stderr.
     *
     * This method captures the stdout and stderr, runs the command using the PicocliRunner,
     * and then returns the output streams.
     *
     * @param args the arguments to pass to the command
     * @return an array containing the output stream and error stream
     */
    String[] executeCommand(String... args) {
        OutputStream out = new ByteArrayOutputStream()
        OutputStream err = new ByteArrayOutputStream()
        System.setOut(new PrintStream(out))
        System.setErr(new PrintStream(err))
        try (ApplicationContext ctx = ApplicationContext.run(Environment.CLI, Environment.TEST)) {
            PicocliRunner.run(FulcrumCommand.class, ctx, args)
        }
        return new String[]{out, err}
    }
}
