package se.pim.view.SystemView;

import se.pim.view.IView;

public class CreatePIRScreenView implements IView {
    @Override
    public void show() {
        System.out.print(viewToString());
    }

    @Override
    public String viewToString() {
        return "╔════════════════════════════════════════════════════════════════════════════════════════════╗\n" +
                "║                                                                                            ║\n" +
                "║                             Create Personal Information Records(PIRs)                      ║\n" +
                "║                                                                                            ║\n" +
                "║                     --------------------------------------------------------               ║\n" +
                "║                     | 1. Create Task                                       |               ║\n" +
                "║                     --------------------------------------------------------               ║\n" +
                "║                     | 2. Create Event                                      |               ║\n" +
                "║                     --------------------------------------------------------               ║\n" +
                "║                     | 3. Create Note                                       |               ║\n" +
                "║                     --------------------------------------------------------               ║\n" +
                "║                     | 4. Create Contact                                    |               ║\n" +
                "║                     --------------------------------------------------------               ║\n" +
                "║                                                                                            ║\n" +
                "║                     Please enter the number of the PIR type you want to create             ║\n" +
                "║                                                                                            ║\n" +
                "╚════════════════════════════════════════════════════════════════════════════════════════════╝\n\n" +
                "**Enter your choice: ";
    }
}
