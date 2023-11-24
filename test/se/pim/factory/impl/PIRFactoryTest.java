package se.pim.factory.impl;

import org.junit.jupiter.api.Test;
import se.pim.model.impl.Contact;
import se.pim.model.impl.Event;
import se.pim.model.impl.Note;
import se.pim.model.impl.Task;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static se.pim.Const.*;

class PIRFactoryTest {

    @Test
    void createContact() {
        String newName = "Test Person";
        String newAddress = "Test address";
        String newPhone = "(+852) 12345678";
        ByteArrayInputStream in = new ByteArrayInputStream(("4" + "\n" + newName + "\n" + newAddress + "\n" + newPhone + "\n" + "\n").getBytes());
        System.setIn(in);
        scanner = new Scanner(System.in);
        Contact contact = (Contact) new PIRFactory().createPIR(1);
        assertAll(
                () -> assertEquals(newName, contact.getName()),
                () -> assertEquals(newAddress, contact.getAddress()),
                () -> assertEquals(newPhone, contact.getPhone())
        );
    }

    @Test
    void createEvent() {
        String newDescription = "TestEvent";
        String newStartTime = "2022/02/02 02:02";
        String newAlarm = "2022/02/01 02:02";
        ByteArrayInputStream in = new ByteArrayInputStream(("2\n" + newDescription + "\n" + newStartTime + "\n" + newAlarm + "\n" + "\n").getBytes());
        System.setIn(in);
        scanner = new Scanner(System.in);
        Event event = (Event) new PIRFactory().createPIR(1);
        assertAll(
                () -> assertEquals(newDescription, event.getDescription()),
                () -> assertEquals(newStartTime, localDateTimeToString(event.getStartTime())),
                () -> assertEquals(newAlarm, localDateTimeToString(event.getAlarm()))
        );
    }

    @Test
    void createNote() {
        String newContent = "Test content";
        ByteArrayInputStream in = new ByteArrayInputStream(("3\n" + newContent + "\n" + "0\n").getBytes());
        System.setIn(in);
        scanner = new Scanner(System.in);
        Note note = (Note) new PIRFactory().createPIR(1);
        assertAll(
                () -> assertEquals(newContent, note.getContent())
        );
    }

    @Test
    void createTask() {
        String newDescription = "TestTask";
        String newDeadLine = "2022/02/02";
        ByteArrayInputStream in = new ByteArrayInputStream(("1\n" + newDescription + "\n" + newDeadLine + "\n" + "\n").getBytes());
        System.setIn(in);
        scanner = new Scanner(System.in);
        Task task = (Task) new PIRFactory().createPIR(1);
        assertAll(
                () -> assertEquals(newDescription, task.getDescription()),
                () -> assertEquals(newDeadLine, dateToString(task.getDeadline()))
        );
    }
}