package se.pim.command.impl;

import se.pim.command.ICommand;
import se.pim.model.IPIR;
import se.pim.view.SystemView.ImportPIRScreenView;

import java.util.Map;

import static se.pim.Const.*;

public class ImportPIRCommand implements ICommand {
    private final Map<Integer, IPIR> pirs;

    public ImportPIRCommand(Map<Integer, IPIR> pirs) {
        this.pirs = pirs;
    }

    @Override
    public void run() {
        new ImportPIRScreenView().show();
        String fileName = scanner.nextLine();
        int result = importPIR(fileName, pirs);
        if (result == -1) System.out.println("Import failed");
        else System.out.println("Imported " + result + " PIRs");
        System.out.print("Press enter to continue...");
        scanner.nextLine();
    }
}
