package se.pim.model.impl;

import se.pim.model.IPIR;

public class Note implements IPIR {
    private String content;
    private final int id;
    public static final String TYPE = "Note";

    public Note(String content, int id) {
        this.content = content;
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }

//    @Override
//    public void edit() {
//        System.out.printf("\n** Edit Note %03d **\n", id);
//        System.out.print(stringOneLine());
//        System.out.println(NOTE_MODIFY_CONTENT);
//        String newContent = scanner.nextLine();
//        if (!newContent.isEmpty())
//            this.setContent(newContent);
//        System.out.println("Edit complete.");
//        System.out.println("** Modified Note **");
//        System.out.print(stringOneLine());
//        System.out.println("\nPress any key to continue...");
//        scanner.nextLine();
//    }

//    @Override
//    public String stringOneLine() {
//        return String.format(PIR_ONELINER, id, TYPE, String.format("%s", content));
//    }
//
//    @Override
//    public String stringDetail() {
//        return String.format(PIR_DETAIL_HEADER, TYPE, id) +
//                String.format(NOTE_DETAIL_CONTENT, content) +
//                String.format(PIR_DETAIL_FOOTER);
//    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
