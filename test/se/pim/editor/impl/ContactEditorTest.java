package se.pim.editor.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.pim.model.impl.Contact;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static se.pim.Const.scanner;

class ContactEditorTest {
    private Contact contact;
    private String newName = "Test Person";
    private String newAddress = "Test address";
    private String newPhone = "(+852) 12345678";

    @BeforeEach
    void setUp() {
        contact = new Contact(
                "Person 1",
                "address address",
                "(+1) 123 456 789",
                1
        );
        ByteArrayInputStream in = new ByteArrayInputStream((newName + "\n" + newAddress + "\n" + newPhone + "\n" + "\n").getBytes());
        System.setIn(in);
        scanner = new Scanner(System.in);
    }

    @Test
    void edit() {
        new ContactEditor(contact).edit();
        assertAll(
                () -> assertEquals(newName, contact.getName()),
                () -> assertEquals(newAddress, contact.getAddress()),
                () -> assertEquals(newPhone, contact.getPhone())
        );
    }
}