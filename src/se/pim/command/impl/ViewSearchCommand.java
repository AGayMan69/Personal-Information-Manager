package se.pim.command.impl;

import se.pim.command.ICommand;

import static se.pim.Const.scanner;

public class viewSearchCommand implements ICommand {
    private final ViewPIRCommand viewPIRCommand;

    public viewSearchCommand(ViewPIRCommand viewPIRCommand) {
        this.viewPIRCommand = viewPIRCommand;
    }

    @Override
    public void run() {
        System.out.println("Enter search term: ");
        viewPIRCommand.setSearch(scanner.next());
    }
}
