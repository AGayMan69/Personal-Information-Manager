package se.pim.command.impl;

import se.pim.command.ICommand;
import se.pim.model.IPIR;
import se.pim.model.impl.Contact;
import se.pim.model.impl.Event;
import se.pim.model.impl.Note;
import se.pim.model.impl.Task;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

import static se.pim.Const.*;

public class ImportPIRCommand implements ICommand {
    private final Map<Integer, IPIR> pirs;

    public ImportPIRCommand(Map<Integer, IPIR> pirs) {
        this.pirs = pirs;
    }

    @Override
    public void run() {
        System.out.print(PIM_IMPORT_SCREEN);
        String fileName = scanner.nextLine();
        int result = importPIR(fileName, pirs);
        if (result == -1) System.out.println("Import failed");
        else System.out.println("Imported " + result + " PIRs");
        System.out.print("Press enter to continue...");
        scanner.nextLine();
    }
}
