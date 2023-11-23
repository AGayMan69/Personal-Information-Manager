package se.pim.editor.impl;

import se.pim.editor.IPIREditor;
import se.pim.model.impl.Task;
import se.pim.view.OneLinerView.TaskOLView;

import static se.pim.Const.*;

public class TaskEditor implements IPIREditor {
    private final Task task;

    public TaskEditor(Task task) {
        this.task = task;
    }

    @Override
    public void edit() {
        System.out.printf("\n** Edit Task %03d **\n", task.getId());
        new TaskOLView(task).show();
        System.out.println();
        System.out.print(TASK_MODIFY_DESCRIPTION);
        String newDescription = scanner.nextLine();
        System.out.print(TASK_MODIFY_DEADLINE);
        String newDeadline = scanner.nextLine();
        if (!newDescription.isEmpty())
            task.setDescription(newDescription);
        if (!newDeadline.isEmpty())
            task.setDeadline(stringToDate(newDeadline));
        System.out.println("Edit complete.");
        System.out.println("** Modified Task **");
        new TaskOLView(task).show();
        System.out.println("\nPress any key to continue...");
        scanner.nextLine();
    }
}
