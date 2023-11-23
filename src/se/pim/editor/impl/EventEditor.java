package se.pim.editor.impl;

import se.pim.editor.IPIREditor;
import se.pim.model.impl.Event;
import se.pim.view.OneLinerView.EventOLView;

import static se.pim.Const.*;

public class EventEditor implements IPIREditor {
    private final Event event;

    public EventEditor(Event event) {
        this.event = event;
    }

    @Override
    public void edit() {
        System.out.printf("\n** Edit Event %03d **\n", event.getId());
        new EventOLView(event).show();
        System.out.println();
        System.out.print(EVENT_MODIFY_DESCRIPTION);
        String newDescription = scanner.nextLine();
        System.out.print(EVENT_MODIFY_START_TIME);
        String newStartTime = scanner.nextLine();
        System.out.print(EVENT_MODIFY_ALARM);
        String newAlarm = scanner.nextLine();
        if (!newDescription.isEmpty())
            event.setDescription(newDescription);
        if (!newStartTime.isEmpty())
            event.setStartTime(stringToLocalDateTime(newStartTime));
        if (!newAlarm.isEmpty())
            event.setAlarm(stringToLocalDateTime(newAlarm));
        System.out.println();
        System.out.println("Edit complete.");
        System.out.println("** Modified Event **");
        new EventOLView(event).show();
        System.out.println("\nPress any key to continue...");
        scanner.nextLine();
    }
}
