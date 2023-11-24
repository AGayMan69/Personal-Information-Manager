package se.pim.factory.impl;

import se.pim.factory.IPIRViewFactory;
import se.pim.model.impl.Note;
import se.pim.view.detailView.NoteDetailView;
import se.pim.view.IView;

public class NoteDetailViewFactory implements IPIRViewFactory {
    private final Note pir;

    public NoteDetailViewFactory(Note pir) {
        this.pir = pir;
    }

    @Override
    public IView createView() {
        return new NoteDetailView(pir);
    }
}
