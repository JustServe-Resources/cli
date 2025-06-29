package org.justserve;

import io.micronaut.configuration.picocli.PicocliRunner;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.client.exceptions.HttpClientResponseException;
import jakarta.inject.Inject;
import org.justserve.client.UserClient;
import org.justserve.model.UserHashRequestByEmail;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(name = "justserve",
        description = "justserve-cli is a terminal tool to help specialists and admin using JustServe")
public class FulcrumCommand implements Runnable {

    @Option(names = {"-e", "--email"}, description = "email for the user whose temporary password will be generated")
    String email;

    @Option(names = {"version", "--version", "-v"})
    boolean version = false;

    String justServeCliVersion = "0.0.2";

    @Inject
    UserClient userClient;

    public static void main(String[] args) {
        PicocliRunner.run(FulcrumCommand.class, args);
    }

    public void run() {
        if (version) {
            justServePrint(justServeCliVersion);
        } else {
            HttpResponse<String> response;
            try {
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

    void justServePrint(String message) {
        System.out.println(message);
    }

    void justServePrintErr(String message, Object... args) {
        System.err.printf(message, args);
    }

}
