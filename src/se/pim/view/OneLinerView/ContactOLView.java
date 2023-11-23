package se.pim.view.OneLinerView;

import se.pim.model.impl.Contact;
import se.pim.view.IView;

import static se.pim.Const.PIR_ONELINER;

public class ContactOLView implements IView {
    private final Contact contact;

    public ContactOLView(Contact contact) {
        this.contact = contact;
    }

    @Override
    public void show() {
        System.out.print(viewToString());
    }

    @Override
    public String viewToString() {
        return String.format(PIR_ONELINER,
                contact.getId(),
                Contact.TYPE,
                String.format("%s, %s", contact.getName(), contact.getPhone()));
    }
}
