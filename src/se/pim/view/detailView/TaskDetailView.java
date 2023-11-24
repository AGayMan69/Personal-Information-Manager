package se.pim.view.detailView;

import se.pim.model.impl.Task;
import se.pim.view.IView;

import static se.pim.Const.*;

public class TaskDetailView implements IView {
    private final Task task;

    public TaskDetailView(Task task) {
        this.task = task;
    }

    public void show() {
        System.out.print(viewToString());
    }

    @Override
    public String viewToString() {
        return String.format(PIR_DETAIL_HEADER, Task.TYPE, task.getId()) +
                String.format(TASK_DETAIL_DESCRIPTION, task.getDescription()) +
                String.format(TASK_DETAIL_DEADLINE, dateToString(task.getDeadline())) +
                String.format(PIR_DETAIL_FOOTER);
    }

    public Task getTask() {
        return task;
    }
}
