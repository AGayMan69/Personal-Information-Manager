package se.pim.command.impl;

import se.pim.command.ICommand;

public class ViewNextPageCommand implements ICommand {
    private final ViewPIRCommand viewPIRCommand;

    public ViewNextPageCommand(ViewPIRCommand viewPIRCommand) {
        this.viewPIRCommand = viewPIRCommand;
    }

    @Override
    public void run() {
        viewPIRCommand.setPage(viewPIRCommand.getPage() + 1);
    }
}
