package se.pim.command.impl;

import se.pim.command.ICommand;
import se.pim.factory.ICommandFactory;
import se.pim.factory.impl.ViewPIRCommandFactory;
import se.pim.model.IPIR;

import java.util.Map;

public class ViewPIRCommand implements ICommand {
    private final Map<Integer, IPIR> pirs;
    private String search;
    private int page;
    private final ICommandFactory commandFactory;
    public ViewPIRCommand(Map<Integer, IPIR> pirs) {
        this.pirs = pirs;
        this.search = "";
        this.page = 1;
        this.commandFactory = new ViewPIRCommandFactory(this);
    }

    @Override
    public void run() {
        while (true) {
            try{
                ICommand command = commandFactory.createCommand();
                if (command == null) continue;
                if (command instanceof ViewExitCommand) break;
                command.run();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public Map<Integer, IPIR> getPirs() {
        return pirs;
    }

    public String getSearch() {
        return search;
    }

    public int getPage() {
        return page;
    }
}
