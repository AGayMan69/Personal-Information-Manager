package se.pim.factory;

import se.pim.command.ICommand;

public interface ICommandFactory {
    ICommand createCommand();

}
