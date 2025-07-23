package org.justserve

import io.micronaut.context.ApplicationContext
import io.micronaut.context.env.Environment
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import spock.lang.Shared
import spock.lang.Specification

@MicronautTest()
class JustServeSpec extends Specification {

    @Shared
    ApplicationContext ctx, noAuthCtx

    @Shared
    String justServeUrl, userEmail

    def setupSpec() {
        if(System.getenv("TEST_TOKEN") == null) {
            throw new IllegalStateException("TEST_TOKEN is NOT set. Define this variable for" +
                    "" +
                    " testing.")
        }
        if (null != System.getenv("JUSTSERVE_TOKEN")) {
            throw new IllegalStateException("JUSTSERVE_TOKEN is set. Do not define this variable in testing.")
        }
        justServeUrl = System.getenv("JUSTSERVE_URL") ?: "https://www.justserve.org"
        if (justServeUrl.toLowerCase().contains("dev")) {
            userEmail = "userc5f660c0-5c3a-42a8-bbe0-8dad54d00f42@fake.justserve.org"
        } else {
            userEmail = "jimmy@justserve.org"
        }
        ctx = ApplicationContext.builder()
                    .environments(Environment.CLI, Environment.TEST)
                    .properties([
                            "justserve.token": System.getenv("TEST_TOKEN"),
                            "micronaut.http.services.justserve.url"  : justServeUrl
                    ])
                    .build()
                    .start()
        noAuthCtx = ApplicationContext
                    .builder()
                    .environments(Environment.CLI, Environment.TEST)
                    .environmentVariableExcludes("JUSTSERVE_TOKEN")
                    .properties(["micronaut.http.services.justserve.url": justServeUrl])
                    .build()
                    .start()
        }

    void cleanupSpec() {
        noAuthCtx.stop()
        ctx.stop()
    }
}
