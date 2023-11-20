package se.pim.factory.impl;

import se.pim.factory.IPIRFactory;
import se.pim.model.IPIR;
import se.pim.model.impl.Contact;
import se.pim.model.impl.Event;
import se.pim.model.impl.Note;
import se.pim.model.impl.Task;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

import static se.pim.Const.*;

public class PIRFactory implements IPIRFactory {
    @Override
    public IPIR createPIR(int id) {
        ClearConsole();
        System.out.print(PIM_CREATE_SCREEN);
        int option = scanner.nextInt();
        scanner.nextLine();
        ClearConsole();
        switch (option) {
            case 1:
                return createTask(id);
            case 2:
                return createEvent(id);
            case 3:
                return createNote(id);
            case 4:
                return createContact(id);
            default:
                return null;
        }
    }

    @Override
    public Contact createContact(int id) {
        String name = null;
        String address = null;
        String phone = null;
        displayCreateContact(name, address, phone);
        System.out.print("** Contact Name **: ");
        name = scanner.nextLine();
        displayCreateContact(name, address, phone);
        System.out.print("** Contact Address **: ");
        address = scanner.nextLine();
        displayCreateContact(name, address, phone);
        System.out.print("** Contact Phone **: ");
        phone = scanner.nextLine();
        displayCreateContact(name, address, phone);
        System.out.print("** Contact Created: press 'enter' to continue **");
        scanner.nextLine();
        return new Contact(name, address, phone, id);
    }

    private static void displayCreateContact(String name, String address, String phone) {
        ClearConsole();
        System.out.printf(
                CONTACT_CREATE_SCREEN,
                name == null ? "________" : name,
                address == null ? "________" : address,
                phone == null ? "________" : phone
        );
    }

    @Override
    public Event createEvent(int id) {
        String description = null;
        LocalDateTime startTime = null;
        LocalDateTime alarm = null;
        displayCreateEvent(description, startTime, alarm);
        System.out.print("** Event Description **: ");
        description = scanner.nextLine();
        displayCreateEvent(description, startTime, alarm);
        System.out.print("** Event Start Time **: ");
        startTime = stringToLocalDateTime(scanner.nextLine());
        displayCreateEvent(description, startTime, alarm);
        System.out.print("** Event Alarm **: ");
        alarm = stringToLocalDateTime(scanner.nextLine());
        displayCreateEvent(description, startTime, alarm);
        System.out.print("** Event Created: press 'enter' to continue **");
        scanner.nextLine();
        return new Event(description, startTime, alarm, id);
    }

    private void displayCreateEvent(String description, LocalDateTime startTime, LocalDateTime alarm) {
        ClearConsole();
        System.out.printf(
                EVENT_CREATE_SCREEN,
                description == null ? "________" : description,
                startTime == null ? "________" : localDateTimeToString(startTime),
                alarm == null ? "________" : localDateTimeToString(alarm)
        );
    }

    @Override
    public Note createNote(int id) {
        String content = null;
        displayCreateNoteContent(content);
        System.out.print("** Note Content **: ");
        content = scanner.nextLine();
        displayCreateNoteContent(content);
        System.out.print("** Note Created: press 'enter' to continue **");
        scanner.nextLine();
        return new Note(content, id);
    }

    private void displayCreateNoteContent(String content) {
        ClearConsole();
        System.out.printf(
                NOTE_CREATE_SCREEN,
                content == null ? "________" : content
        );
    }

    @Override
    public Task createTask(int id) {
        String description = null;
        Date deadline = null;
        displayCreateTask(description, deadline);
        System.out.print("** Task Description **: ");
        description = scanner.nextLine();
        displayCreateTask(description, deadline);
        System.out.print("** Task Deadline **: ");
        deadline = stringToDate(scanner.nextLine());
        displayCreateTask(description, deadline);
        System.out.print("** Task Created: press 'enter' to continue **");
        scanner.nextLine();
        return new Task(description, deadline, id);
    }

    private static void displayCreateTask(String description, Date deadline) {
        ClearConsole();
        System.out.printf(
                TASK_CREATE_SCREEN,
                description == null ? "________" : description,
                deadline == null ? "________" : dateToString(deadline)
        );
    }
}
