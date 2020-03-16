package edu.uqam.tp.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import picocli.CommandLine;

import java.io.IOException;
import java.util.concurrent.Callable;

@CommandLine.Command(
        name = "listAllClientProducts"
)
@Component
@Slf4j
public class ClientListAllProductsCommand implements Callable<Integer> {

    @CommandLine.Parameters
    private String[] clientName;

    // TODO: add --status sub-option
    @CommandLine.Option(names = {"-n"}, description = "Liste tous les produits du client")
    private boolean listAllClientProducts;

    @Override
    public Integer call() {
        int exitCode = 1;
        if (listAllClientProducts) {
            String client = String.join("%20", clientName);
            String command = "curl -i -X GET http://localhost:9999/api/bank/client/list-client-products/" + client;
            try {
                //TODO: return le JSON
                Runtime.getRuntime().exec(command);
                exitCode = 0;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return exitCode;
    }

}
