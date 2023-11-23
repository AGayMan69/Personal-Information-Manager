package se.pim;

import se.pim.model.IPIR;
import se.pim.model.impl.Contact;
import se.pim.model.impl.Event;
import se.pim.model.impl.Note;
import se.pim.model.impl.Task;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Const {
    public static final Scanner scanner = new Scanner(System.in);

    public static int importPIR(String fileName, Map<Integer, IPIR> pirs) {
        pirs.clear();
        try {
            FileReader fileReader = new FileReader(fileName + ".pim");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            int counter = 0;
            while ((line = bufferedReader.readLine()) != null) {
                int id = generateUniqueRandomId(pirs);
                String[] data = line.split(",");
                String type = data[0];
                switch (type) {
                    case "Contact":
                        pirs.put(id, new Contact(data[1], data[2], data[3], id));
                        break;
                    case "Event":
                        pirs.put(id, new Event(data[1], stringToLocalDateTime(data[2]), stringToLocalDateTime(data[3]), id));
                        break;
                    case "Note":
                        pirs.put(id, new Note(data[1], id));
                        break;
                    case "Task":
                        pirs.put(id, new Task(data[1], stringToDate(data[2]), id));
                        break;
                    default:
                        System.out.println("Invalid PIR type");
                        break;
                }
                counter++;
            }
            bufferedReader.close();
            return counter;
        } catch (IOException e) {
            System.err.println(e.getMessage());
            return -1;
        }
    }

    public static Date stringToDate(String str) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        try {
            return formatter.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String dateToString(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        return formatter.format(date);
    }

    public static LocalDateTime stringToLocalDateTime(String str) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
        return LocalDateTime.parse(str, formatter);
    }

    public static String localDateTimeToString(LocalDateTime localDateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
        return localDateTime.format(formatter);
    }

    public static void ClearConsole() {
        try {
            String operatingSystem = System.getProperty("os.name"); //Check the current operating system

            if (operatingSystem.contains("Windows")) {
                ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
                Process startProcess = pb.inheritIO().start();
                startProcess.waitFor();
            } else {
                ProcessBuilder pb = new ProcessBuilder("clear");
                Process startProcess = pb.inheritIO().start();

                startProcess.waitFor();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static int generateUniqueRandomId(Map<Integer, IPIR> map) {
        Random random = new Random();
        int randomInt;
        do {
            randomInt = random.nextInt(1001); // Generate random number between 0 and 1000
        } while (map.containsKey(randomInt));
        return randomInt;
    }
    public static final String PIR_DETAIL_HEADER =
            "╔═════════════════════════════════════════════════════════════════════╗\n" +
                    "║                                                                     ║\n" +
                    "║                         View %-7s Record                         ║\n" +
                    "║                                                                     ║\n" +
                    "║    ----------------------------------------------------------       ║\n" +
                    "║    | ID: %03d                                                |       ║\n" +
                    "║    ----------------------------------------------------------       ║\n";
    public static final String PIR_DETAIL_FOOTER =
            "║                                                                     ║\n" +
                    "║                     [E]dit   [D]elete   [C]lose                     ║\n" +
                    "║                                                                     ║\n" +
                    "╚═════════════════════════════════════════════════════════════════════╝\n" +
                    "**Enter your choice: ";
    public static final String PIR_ONELINER =
            "║                     %03d  |  %-8s| %-47s      ║\n" +
                    "║                     -----|----------|------------------------------------                  ║\n";
    public static final String TASK_DETAIL_DESCRIPTION =
            "║    | Description: %-30s            |       ║\n" +
                    "║    ----------------------------------------------------------       ║\n";

    public static final String TASK_DETAIL_DEADLINE =
            "║    | Deadline: %-10s                                   |       ║\n" +
                    "║    ----------------------------------------------------------       ║\n";
    public static final String CONTACT_DETAIL_NAME =
            "║    | Name: %-10s                                       |       ║\n" +
                    "║    ----------------------------------------------------------       ║\n";
    public static final String CONTACT_DETAIL_ADDRESS =
            "║    | Address: %-20s                          |       ║\n" +
                    "║    ----------------------------------------------------------       ║\n";
    public static final String CONTACT_DETAIL_PHONE =
            "║    | Phone: %-10s                                 |       ║\n" +
                    "║    ----------------------------------------------------------       ║\n";
    public static final String NOTE_DETAIL_CONTENT =
            "║    | Content: %-30s                |       ║\n" +
                    "║    ----------------------------------------------------------       ║\n";
    public static final String EVENT_DETAIL_DESCRIPTION =
            "║    | Description: %-20s                      |       ║\n" +
                    "║    ----------------------------------------------------------       ║\n";
    public static final String EVENT_DETAIL_START_TIME =
            "║    | Start Time: %-20s                       |       ║\n" +
                    "║    ----------------------------------------------------------       ║\n";
    public static final String EVENT_DETAIL_ALARM =
            "║    | Alarm: %-20s                            |       ║\n" +
                    "║    ----------------------------------------------------------       ║\n";
    public static final String TASK_MODIFY_DESCRIPTION = "Enter Description (empty = no change): ";
    public static final String TASK_MODIFY_DEADLINE = "Enter Deadline (e.g. 2023/01/01, empty = no change): ";
    public static final String CONTENT_MODIFY_NAME = "Enter name (empty = no change): ";
    public static final String CONTENT_MODIFY_ADDRESS = "Enter address (empty = no change): ";
    public static final String CONTENT_MODIFY_PHONE = "Enter phone (e.g. (+1) 12345678, empty = no change): ";
    public static final String NOTE_MODIFY_CONTENT = "Enter content (empty = no change): ";
    public static final String EVENT_MODIFY_DESCRIPTION = "Enter description (empty = no change): ";
    public static final String EVENT_MODIFY_START_TIME = "Enter start time (e.g. 2023/01/01 11:59, empty = no change): ";
    public static final String EVENT_MODIFY_ALARM = "Enter alarm (e.g. 2023/01/01 11:59, empty = no change): ";
    public static final String VIEW_RESULT_EMPTY = "║                                                                                            ║\n" +
            "║                                  No result found.                                          ║\n" +
            "║                                                                                            ║\n";
}