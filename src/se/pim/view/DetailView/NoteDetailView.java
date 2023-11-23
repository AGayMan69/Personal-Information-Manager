package se.pim.view.DetailView;

import se.pim.model.impl.Note;
import se.pim.view.IView;

import static se.pim.Const.*;

public class NoteDetailView implements IView {
    private final Note note;

    public NoteDetailView(Note note) {
        this.note = note;
    }

    public void show() {
        System.out.print(viewToString());
    }

    @Override
    public String viewToString() {
        return String.format(PIR_DETAIL_HEADER, Note.TYPE, note.getId()) +
                String.format(NOTE_DETAIL_CONTENT, note.getContent()) +
                String.format(PIR_DETAIL_FOOTER);
    }
}
