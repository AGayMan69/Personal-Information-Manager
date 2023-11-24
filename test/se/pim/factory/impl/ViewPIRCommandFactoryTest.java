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

import static org.junit.jupiter.api.Assertions.*;
import static se.pim.Const.importPIR;
import static se.pim.Const.scanner;

class ViewPIRCommandFactoryTest {
    private ViewPIRCommandFactory viewPIRCommandFactory;

    @BeforeEach
    void setUp() {
        Map<Integer, IPIR> pirs = new HashMap<>();
        ViewPIRCommand viewPIRCommand = new ViewPIRCommand(pirs);
        viewPIRCommandFactory = new ViewPIRCommandFactory(viewPIRCommand);
    }

    @Test
    void createViewNextPageCommand() {
        ByteArrayInputStream in = new ByteArrayInputStream(("n\n").getBytes());
        System.setIn(in);
        scanner = new Scanner(System.in);
        ICommand command = viewPIRCommandFactory.createCommand();
        assertInstanceOf(ViewNextPageCommand.class, command);
    }
    @Test
    void createViewPreviousPageCommand() {
        ByteArrayInputStream in = new ByteArrayInputStream(("p\n").getBytes());
        System.setIn(in);
        scanner = new Scanner(System.in);
        ICommand command = viewPIRCommandFactory.createCommand();
        assertInstanceOf(ViewPreviousPageCommand.class, command);
    }
    @Test
    void createViewSearchCommand() {
        ByteArrayInputStream in = new ByteArrayInputStream(("s\n").getBytes());
        System.setIn(in);
        scanner = new Scanner(System.in);
        ICommand command = viewPIRCommandFactory.createCommand();
        assertInstanceOf(ViewSearchCommand.class, command);
    }
    @Test
    void createPIRDetailCommand() {
        ByteArrayInputStream in = new ByteArrayInputStream(("c\n").getBytes());
        System.setIn(in);
        scanner = new Scanner(System.in);
        ICommand command = viewPIRCommandFactory.createCommand();
        assertInstanceOf(PIRDetailCommand.class, command);
    }
    @Test
    void createViewExitCommand() {
        ByteArrayInputStream in = new ByteArrayInputStream(("e\n").getBytes());
        System.setIn(in);
        scanner = new Scanner(System.in);
        ICommand command = viewPIRCommandFactory.createCommand();
        assertInstanceOf(ViewExitCommand.class, command);
    }
}