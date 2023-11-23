package se.pim.view.SystemView;

import se.pim.view.IView;

public class ViewPIRsScreenView implements IView {
    private final String search;
    private final String pirList;
    private final String paginationList;

    public ViewPIRsScreenView(String search, String pirList, String paginationList) {
        this.search = search;
        this.pirList = pirList;
        this.paginationList = paginationList;
    }

    @Override
    public void show() {
        System.out.print(viewToString());
    }

    @Override
    public String viewToString() {
        return String.format(          "╔════════════════════════════════════════════════════════════════════════════════════════════╗\n" +
                "║                                                                                            ║\n" +
                "║                                      View PIRs                                             ║\n" +
                "║                                                                                            ║\n" +
                "║                     ====================================================                   ║\n" +
                "║                     Search: %-40s                       ║\n" +
                "║                     ====================================================                   ║\n" +
                "║                                                                                            ║\n" +
                "║                     ID   |   Type   |   Summary                                            ║\n" +
                "║                     -----|----------|------------------------------------                  ║\n" +
                "%s" +
                "║                                                                                            ║\n" +
                "║                                                                                            ║\n" +
                "║                     Please enter option:                                                   ║\n" +
                "║                     [S]earch [C]hoose PIR [N]ext Page [P]revious Page [E]xit               ║\n" +
                "║                                                                                            ║\n" +
                "╚════════════════════════════════════════════════════════════════════════════════════════════╝\n" +
                "\n                                %s\n\n" +
                "**Enter your choice: ", search, pirList, paginationList);
    }
}
