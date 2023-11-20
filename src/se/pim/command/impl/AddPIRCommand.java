package se.pim.command.impl;

import se.pim.command.ICommand;
import se.pim.model.IPIR;

import java.util.Map;

public class AddPIRCommand implements ICommand {
    private final Map<Integer, IPIR> pirs;
    private final IPIR pir;

    public AddPIRCommand(Map<Integer, IPIR> pirs, IPIR pir) {
        this.pirs = pirs;
        this.pir = pir;
    }

    @Override
    public void run() {
        pirs.put(pir.getId(), pir);
    }
}
