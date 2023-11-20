package se.pim;

import se.pim.command.ICommand;
import se.pim.factory.ICommandFactory;
import se.pim.factory.impl.CommandFactory;
import se.pim.factory.impl.PIRFactory;
import se.pim.model.IPIR;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static se.pim.Const.importPIR;

public class PersonInformationManager {
    private final ICommandFactory commandFactory;
    private final Map<Integer, IPIR> pirs;

    public PersonInformationManager() {
        pirs = new HashMap<>();
        this.commandFactory = new CommandFactory(pirs, new PIRFactory());
    }

    public void run() {
        importPIR("default", pirs);
        while (true) {
            try {
                ICommand command = commandFactory.createCommand();
                if (command == null) continue;
                command.run();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
