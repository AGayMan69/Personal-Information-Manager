import command.CommandInvoker;
import command.ICommand;
import factory.ICommandFactory;
import factory.impl.CommandFactory;

public class PersonInformationManager {
    private final ICommandFactory commandFactory;
    private final CommandInvoker commandInvoker;

    public PersonInformationManager() {
        this.commandFactory = new CommandFactory();
        this.commandInvoker = new CommandInvoker();
    }

    public void run() {
        while (true) {
            return;
        }
    }
}
