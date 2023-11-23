package se.pim.factory;

import se.pim.model.IPIR;
import se.pim.model.impl.Contact;
import se.pim.model.impl.Event;
import se.pim.model.impl.Note;
import se.pim.model.impl.Task;

public interface IPIRFactory {
    IPIR createPIR(int id);
    Contact createContact(int id);
    Event createEvent(int id);
    Note createNote(int id);
    Task createTask(int id);
}
