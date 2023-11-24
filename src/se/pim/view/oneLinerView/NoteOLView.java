package se.pim.view.oneLinerView;

import se.pim.model.impl.Note;
import se.pim.view.IView;

import static se.pim.Const.PIR_ONELINER;

public class NoteOLView implements IView {
    private final Note note;

    public NoteOLView(Note note) {
        this.note = note;
    }

    @Override
    public void show() {
        System.out.print(viewToString());
    }

    @Override
    public String viewToString() {
        return String.format(PIR_ONELINER,
                note.getId(),
                Note.TYPE,
                String.format("%s", note.getContent()));
    }
}
