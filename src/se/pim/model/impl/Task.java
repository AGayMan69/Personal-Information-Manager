package se.pim.model.impl;

import se.pim.model.IPIR;

import java.util.Date;

public class Task implements IPIR {
    private String description;
    private Date deadline;
    public static final String TYPE = "Task";
    private final int id;

    public Task(String description, Date deadline, int id) {
        this.description = description;
        this.deadline = deadline;
        this.id = id;
    }


    @Override
    public int getId() {
        return id;
    }

//    @Override
//    public void edit() {
//        System.out.printf("\n** Edit Task %03d **\n", id);
//        System.out.print(stringOneLine());
//        System.out.println();
//        System.out.print(TASK_MODIFY_DESCRIPTION);
//        String newDescription = scanner.nextLine();
//        System.out.print(TASK_MODIFY_DEADLINE);
//        String newDeadline = scanner.nextLine();
//        if (!newDescription.isEmpty())
//            this.setDescription(newDescription);
//        if (!newDeadline.isEmpty())
//            this.setDeadline(stringToDate(newDeadline));
//        System.out.println("Edit complete.");
//        System.out.println("** Modified Task **");
//        System.out.print(stringOneLine());
//        System.out.println("\nPress any key to continue...");
//        scanner.nextLine();
//    }

//    @Override
//    public String stringOneLine() {
//        return String.format(PIR_ONELINER, id, TYPE, String.format("After: %s, %s", dateToString(deadline), description.substring(0, Math.min(description.length(), 10))));
//    }
//
//    @Override
//    public String stringDetail() {
//        return String.format(PIR_DETAIL_HEADER, TYPE, id) +
//                String.format(TASK_DETAIL_DESCRIPTION, description) +
//                String.format(TASK_DETAIL_DEADLINE, dateToString(deadline)) +
//                String.format(PIR_DETAIL_FOOTER);
//    }

    public Date getDeadline() {
        return deadline;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }
}
