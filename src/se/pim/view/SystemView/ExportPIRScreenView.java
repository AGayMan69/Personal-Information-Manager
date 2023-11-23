package se.pim.view.SystemView;

import se.pim.view.IView;

public class ExportPIRScreenView implements IView {
    @Override
    public void show() {
        System.out.print(viewToString());
    }

    @Override
    public String viewToString() {
        return "╔════════════════════════════════════════════════════════════════════════════════════════════╗\n" +
                "║                                                                                            ║\n" +
                "║                                   Export PIRs                                              ║\n" +
                "║                                                                                            ║\n" +
                "║                   Please enter the filename with .pim extension                            ║\n" +
                "║                                                                                            ║\n" +
                "║                   Filename: _______.pim                                                    ║\n" +
                "║                                                                                            ║\n" +
                "║                                                                                            ║\n" +
                "╚════════════════════════════════════════════════════════════════════════════════════════════╝\n" +
                "**Enter file name: ";
    }
}
