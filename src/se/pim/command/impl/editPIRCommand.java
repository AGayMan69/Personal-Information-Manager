package se.pim.command.impl;

import se.pim.command.ICommand;
import se.pim.editor.IPIREditor;
import se.pim.editor.impl.ContactEditor;
import se.pim.editor.impl.EventEditor;
import se.pim.editor.impl.NoteEditor;
import se.pim.editor.impl.TaskEditor;
import se.pim.model.IPIR;
import se.pim.model.impl.Contact;
import se.pim.model.impl.Event;
import se.pim.model.impl.Note;
import se.pim.model.impl.Task;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class editPIRCommand implements ICommand {
    private static final Map<Class<? extends IPIR>, Function<IPIR, ? extends IPIREditor>> editorMap;

    static {
        editorMap = new HashMap<>();
        editorMap.put(Contact.class, pir -> new ContactEditor((Contact) pir));
        editorMap.put(Event.class, pir -> new EventEditor((Event) pir));
        editorMap.put(Note.class, pir -> new NoteEditor((Note) pir));
        editorMap.put(Task.class, pir -> new TaskEditor((Task) pir));
    }
    private final IPIR pir;

    public editPIRCommand(IPIR pir) {
        this.pir = pir;
    }

    @Override
    public void run() {
        editorMap.get(pir.getClass()).apply(pir).edit();
    }
}
