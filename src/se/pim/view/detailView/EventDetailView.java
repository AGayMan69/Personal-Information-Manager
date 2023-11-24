package se.pim.view.detailView;

import se.pim.model.impl.Event;
import se.pim.view.IView;

import static se.pim.Const.*;

public class EventDetailView implements IView {
    private final Event event;

    public EventDetailView(Event event) {
        this.event = event;
    }

    public void show() {
        System.out.print(viewToString());
    }

    @Override
    public String viewToString() {
        return String.format(PIR_DETAIL_HEADER, Event.TYPE, event.getId()) +
                String.format(EVENT_DETAIL_DESCRIPTION, event.getDescription()) +
                String.format(EVENT_DETAIL_START_TIME, localDateTimeToString(event.getStartTime())) +
                String.format(EVENT_DETAIL_ALARM, localDateTimeToString(event.getAlarm())) +
                String.format(PIR_DETAIL_FOOTER);
    }

    public Event getEvent() {
        return event;
    }
}
