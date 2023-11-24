package se.pim.command.impl;

import se.pim.command.ICommand;
import se.pim.factory.IPIRViewFactory;
import se.pim.factory.impl.ContactDetailViewFactory;
import se.pim.factory.impl.EventDetailViewFactory;
import se.pim.factory.impl.NoteDetailViewFactory;
import se.pim.factory.impl.TaskDetailViewFactory;
import se.pim.model.IPIR;
import se.pim.model.impl.Contact;
import se.pim.model.impl.Event;
import se.pim.model.impl.Note;
import se.pim.model.impl.Task;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import static se.pim.Const.ClearConsole;
import static se.pim.Const.scanner;

public class PIRDetailCommand implements ICommand {
    private static final Map<Class<? extends IPIR>, Function<IPIR, ? extends IPIRViewFactory>> detailViewFactoryMap;

    static {
        detailViewFactoryMap = new HashMap<>();
        detailViewFactoryMap.put(Contact.class, pir -> new ContactDetailViewFactory((Contact) pir));
        detailViewFactoryMap.put(Event.class, pir -> new EventDetailViewFactory((Event) pir));
        detailViewFactoryMap.put(Note.class, pir -> new NoteDetailViewFactory((Note) pir));
        detailViewFactoryMap.put(Task.class, pir -> new TaskDetailViewFactory((Task) pir));

    }

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
            detailViewFactoryMap.get(pir.getClass()).apply(pir).createView().show();
            char c = scanner.next().trim().charAt(0);
            scanner.nextLine();
            switch (Character.toLowerCase(c)) {
                case 'e':
                    new EditPIRCommand(pir).run();
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
