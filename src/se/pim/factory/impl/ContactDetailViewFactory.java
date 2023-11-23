package se.pim.factory.impl;

import se.pim.factory.IPIRViewFactory;
import se.pim.model.impl.Contact;
import se.pim.view.DetailView.ContactDetailView;
import se.pim.view.IView;

public class ContactDetailViewFactory implements IPIRViewFactory {
    private final Contact pir;

    public ContactDetailViewFactory(Contact pir) {
        this.pir = pir;
    }
    @Override
    public IView createView() {
        return new ContactDetailView(pir);
    }
}
