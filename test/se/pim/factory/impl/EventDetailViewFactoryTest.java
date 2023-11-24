package se.pim.factory.impl;

import org.junit.jupiter.api.Test;
import se.pim.model.impl.Event;
import se.pim.view.detailView.EventDetailView;
import se.pim.view.IView;

import static org.junit.jupiter.api.Assertions.*;
import static se.pim.Const.stringToLocalDateTime;

class EventDetailViewFactoryTest {

    @Test
    void createView() {
        Event event = new Event("test event", stringToLocalDateTime("2023/01/01 12:00"), stringToLocalDateTime("2023/02/02 08:59"), 1);
        IView view = new EventDetailViewFactory(event).createView();
        assertAll(
                () -> assertInstanceOf(EventDetailView.class, view),
                () -> assertEquals(event, ((EventDetailView) view).getEvent())
        );
    }
}