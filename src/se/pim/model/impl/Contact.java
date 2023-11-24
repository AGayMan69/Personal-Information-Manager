package se.pim.model.impl;

import se.pim.model.IPIR;

public class Contact implements IPIR {
    public static final String TYPE = "Contact";
    private final int id;
    private String name;
    private String address;
    private String phone;

    public Contact(String name, String address, String phone, int id) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.id = id;
    }

//    @Override
//    public void edit() {
//        System.out.printf("\n** Edit Contact %03d **\n", id);
//        System.out.print(stringOneLine());
//        System.out.println();
//        System.out.print(CONTENT_MODIFY_NAME);
//        String newName = scanner.nextLine();
//        System.out.print(CONTENT_MODIFY_ADDRESS);
//        String newAddress = scanner.nextLine();
//        System.out.print(CONTENT_MODIFY_PHONE);
//        String newPhone = scanner.nextLine();
//        if (!newName.isEmpty())
//            this.setName(newName);
//        if (!newAddress.isEmpty())
//            this.setAddress(newAddress);
//        if (!newPhone.isEmpty())
//            this.setPhone(newPhone);
//        System.out.println();
//        System.out.println("Edit complete.");
//        System.out.println("** Modified Contact **");
//        System.out.print(stringOneLine());
//        System.out.println("\nPress any key to continue...");
//        scanner.nextLine();
//    }

//    @Override
//    public String stringOneLine() {
//        return String.format(
//                PIR_ONELINER,
//                id,
//                TYPE,
//                String.format("%s, %s", name, address)
//        );
//    }

//    @Override
//    public String stringDetail() {
//        return String.format(PIR_DETAIL_HEADER, TYPE, id) +
//        String.format(CONTACT_DETAIL_NAME, name) +
//        String.format(CONTACT_DETAIL_ADDRESS, address) +
//        String.format(CONTACT_DETAIL_PHONE, phone) +
//        String.format(PIR_DETAIL_FOOTER);
//    }

    @Override
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
