package se.pim.model.impl;

import se.pim.model.IPIR;

import java.time.LocalDateTime;

public class Event implements IPIR {
    public static final String TYPE = "Event";
    private final int id;
    private String description;
    private LocalDateTime startTime;
    private LocalDateTime alarm;

    public Event(String description, LocalDateTime startTime, LocalDateTime alarm, int id) {
        this.description = description;
        this.startTime = startTime;
        this.alarm = alarm;
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }

//    @Override
//    public void edit() {
//        System.out.printf("\n** Edit Event %03d **\n", id);
//        System.out.print(stringOneLine());
//        System.out.println();
//        System.out.print(EVENT_MODIFY_DESCRIPTION);
//        String newDescription = scanner.nextLine();
//        System.out.print(EVENT_MODIFY_START_TIME);
//        String newStartTime = scanner.nextLine();
//        System.out.print(EVENT_MODIFY_ALARM);
//        String newAlarm = scanner.nextLine();
//        if (!newDescription.isEmpty())
//            this.setDescription(newDescription);
//        if (!newStartTime.isEmpty())
//            this.setStartTime(stringToLocalDateTime(newStartTime));
//        if (!newAlarm.isEmpty())
//            this.setAlarm(stringToLocalDateTime(newAlarm));
//        System.out.println();
//        System.out.println("Edit complete.");
//        System.out.println("** Modified Event **");
//        System.out.print(stringOneLine());
//        System.out.println("\nPress any key to continue...");
//        scanner.nextLine();
//    }

//    @Override
//    public String stringOneLine() {
//        return String.format(PIR_ONELINER, id, TYPE, String.format("%s, starting: %s", description, localDateTimeToString(startTime)));
//    }
//
//    @Override
//    public String stringDetail() {
//        return String.format(PIR_DETAIL_HEADER, TYPE, id) +
//                String.format(EVENT_DETAIL_DESCRIPTION, description) +
//                String.format(EVENT_DETAIL_START_TIME, localDateTimeToString(startTime)) +
//                String.format(EVENT_DETAIL_ALARM, localDateTimeToString(alarm)) +
//                String.format(PIR_DETAIL_FOOTER);
//    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getAlarm() {
        return alarm;
    }

    public void setAlarm(LocalDateTime alarm) {
        this.alarm = alarm;
    }
}
