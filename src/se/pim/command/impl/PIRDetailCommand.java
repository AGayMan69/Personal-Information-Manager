package se.pim.command.impl;

import se.pim.command.ICommand;
import se.pim.model.IPIR;

import java.util.Map;

import static se.pim.Const.ClearConsole;
import static se.pim.Const.scanner;

public class ViewDetailCommand implements ICommand{
    private final Map<Integer, IPIR> pirs;

    public ViewDetailCommand(Map<Integer, IPIR> pirs) {
        this.pirs = pirs;
    }

    @Override
    public void run() {
        System.out.print("Please enter the ID of the PIR you want to view:");
        int id = scanner.nextInt();
        IPIR pir;
        do {
            pir = pirs.entrySet()
                    .stream()
                    .filter(IPIREntry -> IPIREntry.getKey() == id)
                    .map(Map.Entry::getValue).findFirst().orElse(null);
        } while (pir == null);
        while (true) {
            ClearConsole();
            System.out.print(pir.stringDetail());
            char c = scanner.next().trim().charAt(0);
            switch (Character.toLowerCase(c)) {
                case 'e':
                    pir.edit();
                    break;
                case 'd':
                    pirs.remove(pir.getId());
                case 'c':
                    return;
            }
        }
    }
}