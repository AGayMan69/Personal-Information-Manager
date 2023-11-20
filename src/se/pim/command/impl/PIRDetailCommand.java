package se.pim.command.impl;

import se.pim.command.ICommand;
import se.pim.model.IPIR;

import java.util.Map;

import static se.pim.Const.ClearConsole;
import static se.pim.Const.scanner;

public class PIRDetailCommand implements ICommand{
    private final Map<Integer, IPIR> pirs;

    public PIRDetailCommand(Map<Integer, IPIR> pirs) {
        this.pirs = pirs;
    }

    @Override
    public void run() {
        IPIR pir;
        do {
            System.out.print("Please enter the ID of the PIR you want to view: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            pir = pirs.entrySet()
                    .stream()
                    .filter(IPIREntry -> IPIREntry.getKey() == id)
                    .map(Map.Entry::getValue).findFirst().orElse(null);
        } while (pir == null);
        while (true) {
            ClearConsole();
            System.out.print(pir.stringDetail());
            char c = scanner.next().trim().charAt(0);
            scanner.nextLine();
            switch (Character.toLowerCase(c)) {
                case 'e':
                    pir.edit();
                    return;
                case 'd':
                    pirs.remove(pir.getId());
                    System.out.printf("\nPIR %03d deleted successfully!\n", pir.getId());
                    System.out.println("Press any key to continue...");
                    scanner.nextLine();
                    return;
                case 'c':
                    return;
            }
        }
    }
}
