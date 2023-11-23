package se.pim.view.CreatePIRView;

import se.pim.view.IView;

import java.util.Date;

import static se.pim.Const.dateToString;

public class CreateTaskView implements IView {
    private final String description;
    private final Date deadline;

    public CreateTaskView(String description, Date deadline) {
        this.description = description;
        this.deadline = deadline;
    }


    @Override
    public void show() {
        System.out.print(viewToString());
    }

    @Override
    public String viewToString() {
        return String.format(
                "╔════════════════════════════════════════════════════════════════════════════════════════════╗\n" +
                        "║                                                                                            ║\n" +
                        "║                                   Create Task PIR                                          ║\n" +
                        "║                                                                                            ║\n" +
                        "║                   Task Description: %-30s                         ║\n" +
                        "║                                                                                            ║\n" +
                        "║                   (e.g. 2023/01/01)                                                        ║\n" +
                        "║                   Task Deadline: %-10s                                                ║\n" +
                        "║                                                                                            ║\n" +
                        "║                                                                                            ║\n" +
                        "╚════════════════════════════════════════════════════════════════════════════════════════════╝\n"
                ,
                description == null ? "________" : description,
                deadline == null ? "________" : dateToString(deadline)
        );
    }
}
