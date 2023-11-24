package se.pim.editor.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.pim.model.impl.Contact;
import se.pim.model.impl.Event;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static se.pim.Const.*;

class EventEditorTest {
    private Event event;
    private String newDescription = "TestEvent";
    private String newStartTime = "2022/02/02 02:02";
    private String newAlarm = "2022/02/01 02:02";

    @BeforeEach
    void setUp() {
        event = new Event(
                "Event 1",
                stringToLocalDateTime("2021/01/02 01:01"),
                stringToLocalDateTime("2021/01/11 01:01"),
                1
        );
        ByteArrayInputStream in = new ByteArrayInputStream((newDescription + "\n" + newStartTime + "\n" + newAlarm + "\n" + "\n").getBytes());
        System.setIn(in);
        scanner = new Scanner(System.in);
    }

    @Test
    void edit() {
        new EventEditor(event).edit();
        assertAll(
                () -> assertEquals(newDescription, event.getDescription()),
                () -> assertEquals(newStartTime, localDateTimeToString(event.getStartTime())),
                () -> assertEquals(newAlarm, localDateTimeToString(event.getAlarm()))
        );
    }
}