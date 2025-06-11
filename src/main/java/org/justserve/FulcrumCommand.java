package org.justserve;

import io.micronaut.context.annotation.Value;
import io.micronaut.configuration.picocli.PicocliRunner;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import jakarta.inject.Inject;
import org.justserve.client.UserClient;
import org.justserve.model.UserHashRequest;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(name = "justserve",
        description = "justserve-cli is a terminal tool to help specialists and admin using JustServe")
public class FulcrumCommand implements Runnable {

    @Option(names = {"-e", "--email"}, description = "email for the user whose temporary password will be generated")
    String email;

    @Option(names = {"version", "--version", "-v"})
    boolean version = false;

    @Value("${justserve-cli-version}")
    String justServeCliVersion;

    @Inject
    UserClient userClient;

    public static void main(String[] args) {
        PicocliRunner.run(FulcrumCommand.class, args);
    }

    public void run() {
        if (version) {
            justServePrint(justServeCliVersion);
        } else {
            HttpResponse<String> response = userClient.getTempPassword(new UserHashRequest(email, null));
            if (response.status() == HttpStatus.OK) {
                justServePrint(response.body().replace("\"", ""));
            } else {
                justServePrintf("received an unexpected response from JustServe : %d%n", response.status().getCode());
            }
        }
    }

    void justServePrint(String message) {
        System.out.println(message);
    }

    void justServePrintf(String message, Object... args) {
        justServePrint(String.format(message, args));
    }

}
