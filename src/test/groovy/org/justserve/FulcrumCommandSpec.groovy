package org.justserve

import io.micronaut.configuration.picocli.PicocliRunner
import io.micronaut.context.ApplicationContext
import io.micronaut.context.env.Environment
import spock.lang.Shared
import spock.lang.Specification

import java.util.regex.Pattern

class FulcrumCommandSpec extends Specification {

    @Shared
    Pattern versionRegex = Pattern.compile "^(\\d\\.){2}\\d\\s{1,2}\$"

    @Shared
    Pattern blankRegex = Pattern.compile "^\\s*\$"

    @Shared
    Pattern errorRegex = Pattern.compile "^received an unexpected response from JustServe: \\d+ \\(.*\\)\\s*\$"

    void "smoke test with command line options"() {
        when:
        def (outputStream, errorStream) = executeCommand(args)

        then:
        outputStream.toString().matches(expectedOutputValue)

        and:
        errorStream.toString().matches(expectedErrorOutput)

        where:
        args                                                      | expectedOutputValue                | expectedErrorOutput | _
        /*test this for print flag*/
        new String[]{'-e', 'jimmy@justserve.org', '-p'}           | Pattern.compile("^\\w+\\s{1,2}\$") | blankRegex          | _
        new String[]{'--email', 'jimmy@justserve.org', '--print'} | Pattern.compile("^\\w+\\s{1,2}\$") | blankRegex          | _
        //it would be nice if we could test that the password was in fact added to the clipboard, for now we are just testing for any response at all
        new String[]{'-e', 'jimmy@justserve.org'}                 | blankRegex                         | blankRegex          | _
        new String[]{'--email', 'jimmy@justserve.org'}            | blankRegex                         | blankRegex          | _
        new String[]{'-v'}                                        | versionRegex                       | blankRegex          | _
        new String[]{"--version"}                                 | versionRegex                       | blankRegex          | _
        new String[]{"version"}                                   | versionRegex                       | blankRegex          | _
        new String[]{"-v"}                                        | versionRegex                       | blankRegex          | _
        //failures
        new String[]{'-e', 'notanemail@mail.moc'}                 | blankRegex                         | errorRegex          | _
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

