package se.pim.factory.impl;

import se.pim.factory.IPIRViewFactory;
import se.pim.model.impl.Task;
import se.pim.view.DetailView.TaskDetailView;
import se.pim.view.IView;

public class TaskDetailViewFactory implements IPIRViewFactory {
    private final Task pir;

    public TaskDetailViewFactory(Task pir) {
        this.pir = pir;
    }
    @Override
    public IView createView() {
        return new TaskDetailView(pir);
    }
}
