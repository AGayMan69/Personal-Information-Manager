package se.pim.view.CreatePIRView;

import se.pim.view.IView;

public class CreateNoteView implements IView {
    private final String content;

    public CreateNoteView(String content) {
        this.content = content;
    }

    @Override
    public void show() {
        System.out.print(viewToString());
    }

    @Override
    public String viewToString() {
        return String.format(
                "╔════════════════════════════════════════════════════════════════════════════════════════════╗\n" +
                        "║                                                                                            ║\n" +
                        "║                                   Create Note PIR                                          ║\n" +
                        "║                                                                                            ║\n" +
                        "║                   Note Content: %-40s                   ║\n" +
                        "║                                                                                            ║\n" +
                        "║                                                                                            ║\n" +
                        "╚════════════════════════════════════════════════════════════════════════════════════════════╝\n",
                content == null ? "________" : content
        );
    }
}
