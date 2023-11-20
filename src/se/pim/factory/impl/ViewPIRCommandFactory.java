package se.pim.factory.impl;

import se.pim.command.ICommand;
import se.pim.command.impl.*;
import se.pim.factory.ICommandFactory;
import se.pim.model.IPIR;

import java.util.Map;

import static se.pim.Const.scanner;

public class ViewPIRCommandFactory implements ICommandFactory {
    private final Map<Integer, IPIR> pirs;
    private final ViewPIRCommand viewPIRCommand;

    public ViewPIRCommandFactory(ViewPIRCommand viewPIRCommand) {
        this.pirs = viewPIRCommand.getPirs();
        this.viewPIRCommand = viewPIRCommand;
    }

    @Override
    public ICommand createCommand() {
        new ListPIRCommand(pirs, viewPIRCommand.getSearch(), viewPIRCommand.getPage(), viewPIRCommand).run();
        char c = scanner.next().trim().charAt(0);
        scanner.nextLine();
        switch (Character.toLowerCase(c)) {
            case 'n':
                return new ViewNextPageCommand(viewPIRCommand);
            case 'p':
                return new ViewPreviousPageCommand(viewPIRCommand);
            case 's':
                return new ViewSearchCommand(viewPIRCommand);
            case 'c':
                return new PIRDetailCommand(pirs);
            case 'e':
                return new ViewExitCommand();
        }
        return null;
    }
}
