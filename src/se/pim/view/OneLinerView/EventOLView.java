package se.pim.view.OneLinerView;

import se.pim.model.impl.Event;
import se.pim.view.IView;

import static se.pim.Const.PIR_ONELINER;
import static se.pim.Const.localDateTimeToString;

public class EventOLView implements IView {
    private final Event event;

    public EventOLView(Event event) {
        this.event = event;
    }
    public void show() {
        System.out.print(viewToString());
    }

    @Override
    public String viewToString() {
        return String.format(PIR_ONELINER, event.getId(), Event.TYPE, String.format("%s, starting: %s", event.getDescription(), localDateTimeToString(event.getStartTime())));
    }
}
