package se.pim.view.SystemView;

import se.pim.view.IView;

public class MainScreenView implements IView {

    @Override
    public void show() {
        System.out.print(viewToString());
    }

    @Override
    public String viewToString() {
        return "╔════════════════════════════════════════════════════════════════════════════════════════════╗\n" +
                "║                                                                                            ║\n" +
                "║                                      Personal Information                                  ║\n" +
                "║                                        Manager (PIM)                                       ║\n" +
                "║                                                                                            ║\n" +
                "║                          -------------------------------------------                       ║\n" +
                "║                          | 1. View Personal Information Records    |                       ║\n" +
                "║                          -------------------------------------------                       ║\n" +
                "║                          | 2. Create Personal Information Records  |                       ║\n" +
                "║                          -------------------------------------------                       ║\n" +
                "║                          | 3. Import Personal Information Records  |                       ║\n" +
                "║                          -------------------------------------------                       ║\n" +
                "║                          | 4. Export Personal Information Records  |                       ║\n" +
                "║                          -------------------------------------------                       ║\n" +
                "║                          | 5. Exit System                          |                       ║\n" +
                "║                          -------------------------------------------                       ║\n" +
                "║                                                                                            ║\n" +
                "║                             Please enter the number of the option                          ║\n" +
                "║                                                                                            ║\n" +
                "╚════════════════════════════════════════════════════════════════════════════════════════════╝\n" +
                "**Enter your choice: ";
    }
}
