package se.pim.factory.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.pim.command.ICommand;
import se.pim.command.impl.*;
import se.pim.model.IPIR;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static se.pim.Const.importPIR;
import static se.pim.Const.scanner;

class CommandFactoryTest {
    private Map<Integer, IPIR> pirs;
    private PIRFactory pirsFactory;

    private CommandFactory commandFactory;

    @BeforeEach
    void setUp() {
        pirsFactory = new PIRFactory();
        pirs = new HashMap<>();
        commandFactory = new CommandFactory(pirs, pirsFactory);
    }

    @Test
    void createViewPIRCommand() {
        ByteArrayInputStream in = new ByteArrayInputStream(("1\n").getBytes());
        System.setIn(in);
        scanner = new Scanner(System.in);
        ICommand command = commandFactory.createCommand();
        assertInstanceOf(ViewPIRCommand.class, command);
    }

    @Test
    void createImportPIRCommand() {
        ByteArrayInputStream in = new ByteArrayInputStream(("3\n").getBytes());
        System.setIn(in);
        scanner = new Scanner(System.in);
        ICommand command = commandFactory.createCommand();
        assertInstanceOf(ImportPIRCommand.class, command);
    }

    @Test
    void createExportPIRCommand() {
        ByteArrayInputStream in = new ByteArrayInputStream(("4\n").getBytes());
        System.setIn(in);
        scanner = new Scanner(System.in);
        ICommand command = commandFactory.createCommand();
        assertInstanceOf(ExportPIRCommand.class, command);
    }

    @Test
    void createExitSystemCommand() {
        ByteArrayInputStream in = new ByteArrayInputStream(("5\n").getBytes());
        System.setIn(in);
        scanner = new Scanner(System.in);
        ICommand command = commandFactory.createCommand();
        assertInstanceOf(ExitSystemCommand.class, command);
    }

    @Test
    void createInvalidCommand() {
        ByteArrayInputStream in = new ByteArrayInputStream(("6\n").getBytes());
        System.setIn(in);
        scanner = new Scanner(System.in);
        ICommand command = commandFactory.createCommand();
        assertNull(command);
    }
}