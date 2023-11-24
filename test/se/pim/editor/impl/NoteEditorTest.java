package se.pim.editor.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.pim.model.impl.Contact;
import se.pim.model.impl.Note;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static se.pim.Const.scanner;

class NoteEditorTest {
    private Note note;
    private String newContent = "Test content";

    @BeforeEach
    void setUp() {
        note = new Note(
                "Note 1",
                1
        );
        ByteArrayInputStream in = new ByteArrayInputStream((newContent + "\n" + "0\n").getBytes());
        System.setIn(in);
        scanner = new Scanner(System.in);
    }

    @Test
    void edit() {
        new NoteEditor(note).edit();
        assertAll(
                () -> assertEquals(newContent, note.getContent())
        );
    }
}