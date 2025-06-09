package org.justserve

import io.micronaut.configuration.picocli.PicocliRunner
import io.micronaut.context.ApplicationContext
import io.micronaut.context.env.Environment
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification

class FulcrumCommandSpec extends Specification {

    @Shared @AutoCleanup ApplicationContext ctx = ApplicationContext.run(Environment.CLI, Environment.TEST)

    void "test fulcrum with command line option"() {
        given:
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream()
        System.setOut(new PrintStream(outputStream))
        ByteArrayOutputStream error = new ByteArrayOutputStream()
        System.setErr(new PrintStream(error))


        String[] args = ['-e', 'jonathan.zollinger+jimmyhook@gmail.com'] as String[]
        PicocliRunner.run(FulcrumCommand, ctx, args)

        expect:
        outputStream.toString() != null

        and:
        error.toString() == null
    }
}

