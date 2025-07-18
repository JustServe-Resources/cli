package org.justserve;

import io.micronaut.configuration.picocli.PicocliRunner;
import io.micronaut.context.annotation.Value;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.client.exceptions.HttpClientResponseException;
import jakarta.inject.Inject;
import jakarta.inject.Provider;
import org.justserve.client.UserClient;
import org.justserve.model.UserHashRequestByEmail;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.jansi.graalvm.AnsiConsole;

import static org.justserve.JustServeUtils.justServePrint;
import static org.justserve.JustServeUtils.justServePrintErr;

@Command(name = "justserve",
        description = "justserve-cli is a terminal tool to help specialists and admin using JustServe")
public class FulcrumCommand implements Runnable {

    @Option(names = {"-e", "--email"}, description = "email for the user whose temporary password will be generated")
    String email;

    @Option(names = {"version", "--version", "-v"})
    boolean version = false;

    @Value("${micronaut.application.version}")
    String justserveCliVersion;

    @Inject
    Provider<UserClient> userClientProvider;

    @Value("${justserve.token}")
    String token;

    public static void main(String[] args) {
        try (AnsiConsole ignored = AnsiConsole.windowsInstall()) {
            PicocliRunner.run(FulcrumCommand.class, args);
        }

    }

    public void run() {
        if (version) {
            justServePrint(justserveCliVersion);
            return;
        }
        HttpResponse<String> response;
        if ("i-need-to-be-defined".equals(token) || null == token ) {
            justServePrintErr("The Authentication token is not assigned as an environment variable. " +
                    "Please define the environment variable \"JUSTSERVE_TOKEN\" and try again.");
            return;
        }
        try {
            UserClient userClient = userClientProvider.get();
            response = userClient.getTempPassword(new UserHashRequestByEmail(email));
        } catch (HttpClientResponseException e) {
            justServePrintErr("received an unexpected response from JustServe: %d (%s)%n",
                    e.getResponse().status().getCode(), e.reason());
            return;
        }
        if (response != null) {
            justServePrint(response.body().replace("\"", ""));
        } else {
            justServePrintErr("An unexpected error occurred. Response from JustServe was null.");
        }
    }
}
