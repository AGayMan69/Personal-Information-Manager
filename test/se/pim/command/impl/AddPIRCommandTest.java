package se.pim.command.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.pim.model.IPIR;
import se.pim.model.impl.Contact;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class AddPIRCommandTest {
    Map<Integer, IPIR> pirs;
    Contact newContact;

    @BeforeEach
    void setUp() {
        pirs = new HashMap<>();

        newContact = new Contact(
                "TestName",
                "TestAddress",
                "(+852) 88787887",
                1
        );

    }

    @Test
    void run() {
        new AddPIRCommand(pirs, newContact).run();
        assertSame(pirs.get(1), newContact);
    }
}