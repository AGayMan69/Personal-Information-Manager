package se.pim.factory.impl;

import org.junit.jupiter.api.Test;
import se.pim.model.impl.Note;
import se.pim.view.detailView.NoteDetailView;
import se.pim.view.IView;

import static org.junit.jupiter.api.Assertions.*;

class NoteDetailViewFactoryTest {

    @Test
    void createView() {
        Note note = new Note("test note", 1);
        NoteDetailViewFactory noteDetailViewFactory = new NoteDetailViewFactory(note);
        IView view = noteDetailViewFactory.createView();
        assertAll(
                () -> assertInstanceOf(NoteDetailView.class, view),
                () -> assertEquals(note, ((NoteDetailView) view).getNote())
        );
    }
}