package se.pim.command.impl;

import se.pim.command.ICommand;

public class viewPreviousPageCommand implements ICommand {
    private final ViewPIRCommand viewPIRCommand;

    public viewPreviousPageCommand(ViewPIRCommand viewPIRCommand) {
        this.viewPIRCommand = viewPIRCommand;
    }

    @Override
    public void run() {
        viewPIRCommand.setPage(Math.max(0, viewPIRCommand.getPage() - 1));
    }
}
