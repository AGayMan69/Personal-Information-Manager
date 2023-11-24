package se.pim.factory.impl;

import org.junit.jupiter.api.Test;
import se.pim.model.impl.Contact;
import se.pim.view.detailView.ContactDetailView;
import se.pim.view.IView;

import static org.junit.jupiter.api.Assertions.*;

class ContactDetailViewFactoryTest {

    @Test
    void createView() {
        Contact contact = new Contact("test person", "address address", "(123) 456-7890", 1);
        IView view = new ContactDetailViewFactory(contact).createView();
        assertAll(
                () -> assertInstanceOf(ContactDetailView.class, view),
                () -> assertEquals(contact, ((ContactDetailView) view).getContact())
        );
    }
}