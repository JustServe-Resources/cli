package org.justserve

import io.micronaut.configuration.picocli.PicocliRunner
import io.micronaut.context.ApplicationContext
import io.micronaut.context.env.Environment

import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification

class CliCommandSpec extends Specification {

    @Shared @AutoCleanup ApplicationContext ctx = ApplicationContext.run(Environment.CLI, Environment.TEST)

    void "test cli with command line option"() {
        given:
        ByteArrayOutputStream baos = new ByteArrayOutputStream()
        System.setOut(new PrintStream(baos))

        String[] args = ['-v'] as String[]
        PicocliRunner.run(CliCommand, ctx, args)

        expect:
        baos.toString().contains('Hi!')
    }

    void "read cell from excel sheet"(){
        given:
        String workbook=new ExcelWorkbook("C:/Users/Bilbo.Sacket/github/JustServeResources/cli-main/cli/src/test/resources/Book.xlsx")
        String cellValue=workbook.readCell("Sheet1", 0, 0)
        expect:
        assert cellValue == "hello world"
    }
}

