package se.pim.editor.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.pim.model.impl.Task;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static se.pim.Const.*;

class TaskEditorTest {
    private Task task;

    private String newDescription = "TestTask";
    private String newDeadLine = "2022/02/02";

    @BeforeEach
     void setUp() {
        task = new Task(
                "Task 1",
                stringToDate("2021/01/02"),
                1
        );
        ByteArrayInputStream in = new ByteArrayInputStream((newDescription + "\n" + newDeadLine + "\n" + "\n").getBytes());
        System.setIn(in);
        scanner = new Scanner(System.in);
    }

    @Test
    void edit() {
        new TaskEditor(task).edit();
        assertAll(
                () -> assertEquals(newDescription, task.getDescription()),
                () -> assertEquals(newDeadLine, dateToString(task.getDeadline()))
        );
    }
}