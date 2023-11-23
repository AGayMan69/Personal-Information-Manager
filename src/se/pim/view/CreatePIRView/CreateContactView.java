package se.pim.view.CreatePIRView;

import se.pim.view.IView;

public class CreateContactView implements IView {
    private final String name;
    private final String address;
    private final String phone;

    public CreateContactView(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    @Override
    public void show() {
        System.out.print(viewToString());
    }

    @Override
    public String viewToString() {
        return String.format("╔════════════════════════════════════════════════════════════════════════════════════════════╗\n" +
                        "║                                                                                            ║\n" +
                        "║                                   Create Contact PIR                                       ║\n" +
                        "║                                                                                            ║\n" +
                        "║                   Contact Name: %-15s                                            ║\n" +
                        "║                                                                                            ║\n" +
                        "║                   Contact Address: %-15s                                         ║\n" +
                        "║                                                                                            ║\n" +
                        "║                   (e.g. (+1) 12345678)                                                     ║\n" +
                        "║                   Contact Phone: %-15s                                           ║\n" +
                        "║                                                                                            ║\n" +
                        "║                                                                                            ║\n" +
                        "╚════════════════════════════════════════════════════════════════════════════════════════════╝\n",
                name == null ? "________" : name,
                address == null ? "________" : address,
                phone == null ? "________" : phone
        );
    }
}
