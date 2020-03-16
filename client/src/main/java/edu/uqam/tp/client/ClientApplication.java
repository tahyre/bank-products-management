package edu.uqam.tp.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import picocli.CommandLine;

@Slf4j
@SpringBootApplication
public class ClientApplication implements CommandLineRunner {

    private ClientListAllProductsCommand listAllProductsCommand;

    public ClientApplication(ClientListAllProductsCommand listAllProductsCommand) {
        this.listAllProductsCommand = listAllProductsCommand;
    }

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        CommandLine commandLine = new CommandLine(listAllProductsCommand);
        int exitCode = commandLine.execute(args);
        if (exitCode == 0) {
            log.info(String.format("La liste des produits a été obtenu avec succès. Exit code: %d", exitCode));
            //System.exit(exitCode);
        } else {
            log.warn(String.format("La commande pour avoir la liste de produits client a échoué. Exit code: %d", exitCode));
            //System.exit(exitCode);
        }
    }
}
