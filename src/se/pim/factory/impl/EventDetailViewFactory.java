package se.pim.factory.impl;

import se.pim.factory.IPIRViewFactory;
import se.pim.model.impl.Event;
import se.pim.view.detailView.EventDetailView;
import se.pim.view.IView;

public class EventDetailViewFactory implements IPIRViewFactory {
    private final Event pir;

    public EventDetailViewFactory(Event pir) {
        this.pir = pir;
    }

    @Override
    public IView createView() {
        return new EventDetailView(pir);
    }
}
