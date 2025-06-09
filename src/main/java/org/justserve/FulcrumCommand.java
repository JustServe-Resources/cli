package org.justserve;

import io.micronaut.configuration.picocli.PicocliRunner;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import jakarta.inject.Inject;
import org.justserve.client.UserClient;
import org.justserve.model.UserHashRequest;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(name = "justserve", description = "justserve-cli is a terminal tool to help specialists and admin using JustServe",
        mixinStandardHelpOptions = true)
public class FulcrumCommand implements Runnable {

    @Option(names = {"-e", "--email"}, description = "email for the user whose temporary password will be generated")
    String email;

    @Inject
    UserClient userClient;

    public static void main(String[] args) {
        PicocliRunner.run(FulcrumCommand.class, args);
    }

    public void run() {
        HttpResponse<String> response = userClient.getTempPassword(new UserHashRequest(email, null));
        if (response.status() == HttpStatus.OK) {
            System.out.println(response.body().replace("\"", ""));
        } else {
            System.out.printf("received an unexpected response from JustServe : %d%n", response.status().getCode());
        }
    }
}
