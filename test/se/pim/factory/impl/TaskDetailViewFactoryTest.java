package se.pim.factory.impl;

import org.junit.jupiter.api.Test;
import se.pim.model.impl.Task;
import se.pim.view.detailView.TaskDetailView;
import se.pim.view.IView;

import static org.junit.jupiter.api.Assertions.*;
import static se.pim.Const.stringToDate;

class TaskDetailViewFactoryTest {

    @Test
    void createView() {
        Task task = new Task("test task", stringToDate("2023/05/05"), 1);
        TaskDetailViewFactory taskDetailViewFactory = new TaskDetailViewFactory(task);
        IView view = taskDetailViewFactory.createView();
        assertAll(
                () -> assertInstanceOf(TaskDetailView.class, view),
                () -> assertEquals(task, ((TaskDetailView) view).getTask())
        );
    }
}