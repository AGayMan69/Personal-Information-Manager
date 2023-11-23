package se.pim.view.CreatePIRView;

import se.pim.view.IView;

import java.time.LocalDateTime;

import static se.pim.Const.localDateTimeToString;

public class CreateEventView implements IView {
    private final String description;
    private final LocalDateTime startTime;
    private final LocalDateTime alarm;

    public CreateEventView(String description, LocalDateTime startTime, LocalDateTime alarm) {
        this.description = description;
        this.startTime = startTime;
        this.alarm = alarm;
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
                        "║                                   Create Event PIR                                         ║\n" +
                        "║                                                                                            ║\n" +
                        "║                   Event Description: %-30s                        ║\n" +
                        "║                                                                                            ║\n" +
                        "║                   (e.g. 2023/01/01 11:59)                                                  ║\n" +
                        "║                   Event Start Time: %-16s                                       ║\n" +
                        "║                                                                                            ║\n" +
                        "║                   (e.g. 2023/01/01 11:59)                                                  ║\n" +
                        "║                   Event Alarm: %-16s                                            ║\n" +
                        "║                                                                                            ║\n" +
                        "║                                                                                            ║\n" +
                        "╚════════════════════════════════════════════════════════════════════════════════════════════╝\n",
                description == null ? "________" : description,
                startTime == null ? "________" : localDateTimeToString(startTime),
                alarm == null ? "________" : localDateTimeToString(alarm)
        );
    }
}
