package se.pim.command.impl;

import se.pim.command.ICommand;

import static se.pim.Const.scanner;

public class ViewSearchCommand implements ICommand {
    private final ViewPIRCommand viewPIRCommand;

    public ViewSearchCommand(ViewPIRCommand viewPIRCommand) {
        this.viewPIRCommand = viewPIRCommand;
    }

    @Override
    public void run() {
        System.out.print("Enter search term: ");
        viewPIRCommand.setSearch(scanner.nextLine());
    }
}
