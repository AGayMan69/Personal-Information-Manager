package se.pim.command.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.pim.model.impl.Contact;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static se.pim.Const.scanner;

class editPIRCommandTest {
    Contact editContact;
    String testName = "Person test";
    String testAddress = "Address test";
    String testPhone = "(+852) 88787887";

    @BeforeEach
    void setUp() {
        editContact = new Contact(
                "Person 1",
                "address address",
                "(+1) 324234",
                1
        );
        ByteArrayInputStream in = new ByteArrayInputStream((testName + "\n" + testAddress + "\n" + testPhone + "\n" + "0\n").getBytes());
        System.setIn(in);
        scanner = new Scanner(System.in);
    }

    @Test
    void run() {
        new EditPIRCommand(editContact).run();
        assertAll(
                () -> assertEquals(testName, editContact.getName()),
                () -> assertEquals(testAddress, editContact.getAddress()),
                () -> assertEquals(testPhone, editContact.getPhone())
        );
    }
}