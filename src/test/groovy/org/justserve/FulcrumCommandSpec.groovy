package org.justserve

import io.micronaut.configuration.picocli.PicocliRunner
import io.micronaut.context.ApplicationContext
import spock.lang.Shared
import spock.lang.Unroll

import java.util.regex.Pattern

class FulcrumCommandSpec extends JustServeSpec {

    @Shared
    Pattern cliVersion

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
        def props = new Properties()
        new File('gradle.properties').withInputStream { stream ->
            props.load(stream)
        }
        cliVersion = Pattern.compile("^" + props.getProperty('justserveCliVersion') + "\\s*\$")
    }

    @Unroll("command with args: calling 'justserve #flag #email' works as expected")
    def "commands to query temporary password should behave as expected with or without authentication"() {
        when:
        def (outputStream, errorStream) = executeCommand(context as ApplicationContext, [flag, email] as String[])

        then:
        if (context == noAuthCtx) {
            verifyAll {
                outputStream.toString().matches(blankRegex)
                errorStream.toString().matches(tokenNotSetRegex)
            }
        } else if (userEmail.equalsIgnoreCase(email as String)) {
            verifyAll {
                outputStream.toString().matches(successRegex)
                errorStream.toString().matches(blankRegex)
            }
        } else {
            verifyAll {
                outputStream.toString().matches(blankRegex)
                errorStream.toString().matches(errorRegex)
            }
        }

        where:
        [flag, email, context] << [['-e', '--email'], [userEmail, "notanemail@mail.moc"], [noAuthCtx, ctx]].combinations()
    }

    @Unroll
    def "querying version returns current version, with or without authentication"() {
        when:
        def (outputStream, errorStream) = executeCommand(context as ApplicationContext, args as String[])

        then:
        verifyAll {
            outputStream.toString().matches(cliVersion)
            errorStream.toString().matches(blankRegex)
        }

        where:
        [args, context] << [[['-v'], ['--version'], ['version']], [noAuthCtx, ctx]].combinations()
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
