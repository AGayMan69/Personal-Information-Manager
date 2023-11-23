package se.pim.editor.impl;

import se.pim.editor.IPIREditor;
import se.pim.model.impl.Contact;
import se.pim.view.OneLinerView.ContactOLView;

import static se.pim.Const.*;

public class ContactEditor implements IPIREditor {
    private final Contact contact;

    public ContactEditor(Contact contact) {
        this.contact = contact;
    }
    @Override
    public void edit() {
        System.out.printf("\n** Edit Contact %03d **\n", contact.getId());
        new ContactOLView(contact).show();
        System.out.println();
        System.out.print(CONTENT_MODIFY_NAME);
        String newName = scanner.nextLine();
        System.out.print(CONTENT_MODIFY_ADDRESS);
        String newAddress = scanner.nextLine();
        System.out.print(CONTENT_MODIFY_PHONE);
        String newPhone = scanner.nextLine();
        if (!newName.isEmpty())
            (contact).setName(newName);
        if (!newAddress.isEmpty())
            (contact).setAddress(newAddress);
        if (!newPhone.isEmpty())
            (contact).setPhone(newPhone);
        System.out.println();
        System.out.println("Edit complete.");
        System.out.println("** Modified Contact **");
        new ContactOLView(contact).show();
        System.out.println("\nPress any key to continue...");
        scanner.nextLine();
    }
}
