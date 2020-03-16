package edu.uqam.tp.employee;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import picocli.CommandLine;

@Slf4j
@SpringBootApplication
public class EmployeeApplication implements CommandLineRunner {

    private EmployeeAddClientCommand addClientCommand;

    public EmployeeApplication(EmployeeAddClientCommand addClientCommand) {
        this.addClientCommand = addClientCommand;
    }

    public static void main(String[] args) {
        SpringApplication.run(EmployeeApplication.class, args);
    }

    @Override
    public void run(String... args) {
        CommandLine commandLine = new CommandLine(addClientCommand);
        int exitCode = commandLine.execute(args);
        if (exitCode == 0) {
            log.info(String.format("Le client a été ajouté avec succès. Exit code: %d", exitCode));
            //System.exit(exitCode);
        } else {
            log.warn(String.format("La commande d'ajout client a échoué. Exit code: %d", exitCode));
            //System.exit(exitCode);
        }
    }
}
