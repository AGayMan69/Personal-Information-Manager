package se.pim.command.impl;

import se.pim.command.ICommand;

public class ViewPreviousPageCommand implements ICommand {
    private final ViewPIRCommand viewPIRCommand;

    public ViewPreviousPageCommand(ViewPIRCommand viewPIRCommand) {
        this.viewPIRCommand = viewPIRCommand;
    }

    @Override
    public void run() {
        viewPIRCommand.setPage(Math.max(1, viewPIRCommand.getPage() - 1));
    }
}
