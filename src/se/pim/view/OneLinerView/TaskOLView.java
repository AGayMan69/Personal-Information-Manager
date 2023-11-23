package se.pim.view.OneLinerView;

import se.pim.model.impl.Task;
import se.pim.view.IView;

import static se.pim.Const.PIR_ONELINER;
import static se.pim.Const.dateToString;

public class TaskOLView implements IView {
    private final Task task;

    public TaskOLView(Task task) {
        this.task = task;
    }

    public void show() {
        System.out.print(viewToString());
    }

    @Override
    public String viewToString() {
        return String.format(PIR_ONELINER, task.getId(), Task.TYPE, String.format("After: %s, %s", dateToString(task.getDeadline()), task.getDescription().substring(0, Math.min(task.getDescription().length(), 10))));
    }
}
