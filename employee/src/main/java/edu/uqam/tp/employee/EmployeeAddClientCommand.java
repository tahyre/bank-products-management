package edu.uqam.tp.employee;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import picocli.CommandLine;

import java.io.IOException;
import java.util.concurrent.Callable;

@CommandLine.Command(
        name = "add"
)
@Component
@Slf4j
public class EmployeeAddClientCommand implements Callable<Integer> {

    @CommandLine.Parameters
    private String[] clientName;

    @CommandLine.Option(names = {"--add"}, description = "créer un client de nom CLIENT_NAME")
    private boolean addClient;

    @Override
    public Integer call() {
        int exitCode = 1;
        if (addClient) {
            String client = String.join("%20", clientName);
            String command = "curl -i -X PUT http://localhost:9999/api/bank/employee/add-client/" + client;
            try {
                Runtime.getRuntime().exec(command);
                exitCode = 0;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return exitCode;
    }
}
