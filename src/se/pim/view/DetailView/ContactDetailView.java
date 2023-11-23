package se.pim.view.DetailView;

import se.pim.model.impl.Contact;
import se.pim.view.IView;

import static se.pim.Const.*;


public class ContactDetailView implements IView {
    private final Contact contact;

    public ContactDetailView(Contact contact) {
        this.contact = contact;
    }

    @Override
    public void show() {
        System.out.print(viewToString());
    }

    @Override
    public String viewToString() {
        return String.format(PIR_DETAIL_HEADER, Contact.TYPE, contact.getId()) +
                String.format(CONTACT_DETAIL_NAME, contact.getName()) +
                String.format(CONTACT_DETAIL_ADDRESS, contact.getAddress()) +
                String.format(CONTACT_DETAIL_PHONE, contact.getPhone()) +
                String.format(PIR_DETAIL_FOOTER);
    }
}
