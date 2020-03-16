package edu.uqam.tp.employee;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import picocli.CommandLine;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class EmployeeAddClientCommandTests {

    private EmployeeAddClientCommand addClientCommand;

    @BeforeEach
    public void setUP() {
        System.clearProperty("picocli.trace");
        addClientCommand = new EmployeeAddClientCommand();
    }

    @Test
    public void addClientCommand_shouldHave_AddOption_andAtLeast_OneClientNameParameter() {
        // arrange
        String[] args = {"--add", "John", "Smith"};

        //act
        CommandLine.ParseResult parseResult = new CommandLine(addClientCommand).parseArgs(args);

        // assert that option is equal to --add and we have at least one client name parameter
        assertTrue(parseResult.hasMatchedOption("--add"));
        assertTrue(parseResult.hasMatchedPositional(0));
    }
}
