package org.justserve

import io.micronaut.configuration.picocli.PicocliRunner
import io.micronaut.context.ApplicationContext
import io.micronaut.context.env.Environment
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification

class FulcrumCommandSpec extends Specification {

    @Shared
    @AutoCleanup
    ApplicationContext ctx = ApplicationContext.run(Environment.CLI, Environment.TEST)

    void "smoke test with command line options"() {

        when:
        def (outputStream, errorStream) = executeCommand(args)

        then:
        outputStream.toString() != null

        and:
        errorStream.toString().length() == 0

        where:
        args                                                         | _
        new String[]{'-e', 'jonathan.zollinger+jimmyhook@gmail.com'} | _
        new String[]{'-v'}                                           | _
        new String[]{"--version"}                                    | _
        new String[]{"version"}                                      | _
        new String[]{"-v"}                                           | _

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
        System.setErr(new PrintStream(out))
        try (ApplicationContext ctx = ApplicationContext.run(Environment.CLI, Environment.TEST)) {
            PicocliRunner.run(FulcrumCommand.class, ctx, args)
        }
        return new String[]{out, err}
    }
}

