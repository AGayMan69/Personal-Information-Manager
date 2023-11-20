package se.pim.factory;

import se.pim.command.ICommand;
import se.pim.model.IPIR;

import java.util.Map;

public interface ICommandFactory {
    ICommand createCommand();

}
