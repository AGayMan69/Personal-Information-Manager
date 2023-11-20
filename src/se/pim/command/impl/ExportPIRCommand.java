package se.pim.command.impl;

import se.pim.Const;
import se.pim.command.ICommand;
import se.pim.model.IPIR;
import se.pim.model.impl.Contact;
import se.pim.model.impl.Event;
import se.pim.model.impl.Note;
import se.pim.model.impl.Task;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import static se.pim.Const.*;

public class ExportPIRCommand implements ICommand {
    private final Map<Integer, IPIR> pirs;

    public ExportPIRCommand(Map<Integer, IPIR> pirs) {
        this.pirs = pirs;
    }

    @Override
    public void run() {
        System.out.print(PIM_EXPORT_SCREEN);
        String fileName = scanner.nextLine();
        int result = exportPIR(fileName);
        if (result == -1) System.out.println("Export failed");
        else System.out.println("Exported " + result + " PIRs");
    }

    private int exportPIR(String fileName) {
        try {
            FileWriter fileWriter = new FileWriter(fileName + ".pim");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (IPIR pir : pirs.values()) {
                if (pir instanceof Contact) {
                    Contact contact = (Contact) pir;
                    bufferedWriter.write("Contact," + contact.getName() + "," + contact.getAddress() + "," + contact.getPhone() + "\n");
                } else if (pir instanceof Event) {
                    Event event = (Event) pir;
                    bufferedWriter.write("Event," + event.getDescription() + "," + localDateTimeToString(event.getStartTime()) + "," + localDateTimeToString(event.getAlarm()) + "\n");
                } else if (pir instanceof Note) {
                    Note note = (Note) pir;
                    bufferedWriter.write("Note," + note.getContent() + "\n");
                } else if (pir instanceof Task) {
                    Task task = (Task) pir;
                    bufferedWriter.write("Task," + task.getDescription() + "," + dateToString(task.getDeadline()) + "\n");
                }
            }
            bufferedWriter.close();
            return pirs.size();
        } catch (IOException e) {
            System.err.println(e.getMessage());
            return -1;
        }
    }
}
