package se.pim.command.impl;

import se.pim.command.ICommand;

public class ExitSystemCommand implements ICommand {
    @Override
    public void run() {
        System.exit(0);
    }
}
