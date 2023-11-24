package se.pim.factory.impl;

import se.pim.Const;
import se.pim.command.ICommand;
import se.pim.command.impl.*;
import se.pim.factory.ICommandFactory;
import se.pim.model.IPIR;
import se.pim.view.systemView.MainScreenView;

import java.util.Map;

import static se.pim.Const.generateUniqueRandomId;
import static se.pim.Const.scanner;

public class CommandFactory implements ICommandFactory {
    private final Map<Integer, IPIR> pirs;
    private final PIRFactory pirFactory;

    public CommandFactory(Map<Integer, IPIR> pirs, PIRFactory pirFactory) {
        this.pirs = pirs;
        this.pirFactory = pirFactory;
    }

    @Override
    public ICommand createCommand() {
        Const.ClearConsole();
        new MainScreenView().show();
        if (scanner.hasNextInt()) {
            int opt = scanner.nextInt();
            scanner.nextLine();
            switch (opt) {
                case 1:
                    return new ViewPIRCommand(pirs);
                case 2:
                    return new AddPIRCommand(pirs, pirFactory.createPIR(generateUniqueRandomId(pirs)));
                case 3:
                    return new ImportPIRCommand(pirs);
                case 4:
                    return new ExportPIRCommand(pirs);
                case 5:
                    return new ExitSystemCommand();
                default:
                    return null;
            }
        }
        scanner.nextLine();
        return null;
    }
}
