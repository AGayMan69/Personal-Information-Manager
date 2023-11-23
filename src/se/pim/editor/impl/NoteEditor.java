package se.pim.editor.impl;

import se.pim.editor.IPIREditor;
import se.pim.model.impl.Note;
import se.pim.view.OneLinerView.NoteOLView;

import static se.pim.Const.NOTE_MODIFY_CONTENT;
import static se.pim.Const.scanner;

public class NoteEditor implements IPIREditor {
    private final Note note;

    public NoteEditor(Note note) {
        this.note = note;
    }

    @Override
    public void edit() {
        System.out.printf("\n** Edit Note %03d **\n", note.getId());
        new NoteOLView(note).show();
        System.out.println(NOTE_MODIFY_CONTENT);
        String newContent = scanner.nextLine();
        if (!newContent.isEmpty())
            note.setContent(newContent);
        System.out.println("Edit complete.");
        System.out.println("** Modified Note **");
        new NoteOLView(note).show();
        System.out.println("\nPress any key to continue...");
        scanner.nextLine();
    }
}
