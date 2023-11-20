package se.pim.command.impl;

import org.mvel2.MVEL;
import org.mvel2.PropertyAccessException;
import se.pim.Const;
import se.pim.command.ICommand;
import se.pim.model.IPIR;
import se.pim.model.impl.Contact;
import se.pim.model.impl.Event;
import se.pim.model.impl.Note;
import se.pim.model.impl.Task;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static se.pim.Const.*;

public class ListPIRCommand implements ICommand {
    private final Map<Integer, IPIR> pirs;
    private final String search;
    private final int page;
    private final int size = 10;
    private int totalPages = 0;

    private ViewPIRCommand viewPIRCommand;

    public ListPIRCommand(Map<Integer, IPIR> pirs, String search, int page, ViewPIRCommand viewPIRCommand) {
        this.pirs = pirs;
        this.search = search;
        this.page = page;
        this.viewPIRCommand = viewPIRCommand;
    }


    @Override
    public void run() {
        String pirListStr = generatePirListStr();
        if (totalPages < viewPIRCommand.getPage()) {
            viewPIRCommand.setPage(totalPages);
        }
        String paginationList = generatePaginationList();
        System.out.printf(PIM_VIEW_SCREEN, search.equals("") ? "___________" : search, pirListStr, paginationList);
    }

    private Map<Integer, IPIR> searchPirList(String searchString) {
        QueryParser queryParser = new QueryParser(searchString);
        Predicate<IPIR> predicate = queryParser.getPredicate();

        Map<Integer, IPIR> filteredMap = pirs.entrySet().stream()
                .filter(entry -> predicate.test(entry.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        return filteredMap;
    }

    private Map<Integer, IPIR> getPaginatedMap(Map<Integer, IPIR> filteredMap, int page, int size) {
        int start = (page - 1) * size;

        return filteredMap.entrySet().stream()
                .skip(start)
                .limit(size)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    private String generatePirListStr() {
        Map<Integer, IPIR> filteredPIRS;
        if ("".equals(search)) {
            filteredPIRS = pirs;
        } else {
            filteredPIRS = searchPirList(search);
        }
        int totalElements = filteredPIRS.size();
        totalPages = (int) Math.ceil((double) totalElements / size);
        if (totalPages == 0) {
            return VIEW_RESULT_EMPTY;
        }
        Map<Integer, IPIR> paginatedMap = getPaginatedMap(filteredPIRS, Math.min(page, totalPages), size);

        StringBuilder pirListStr = new StringBuilder();
        for (Map.Entry<Integer, IPIR> entry : paginatedMap.entrySet()) {
            IPIR ipir = entry.getValue();
            pirListStr.append(ipir.stringOneLine());
        }

        return pirListStr.toString();
    }

    private String generatePaginationList() {
        if (totalPages == 0) {
            return "";
        }
        StringBuilder paginationList = new StringBuilder();
        int currentPage = Math.min(page, totalPages);
        for (int i = 1; i <= totalPages; i++) {
            if (i == currentPage) {
                paginationList.append(String.format(" [%d] ", i));
            } else {
                paginationList.append(String.format(" %d ", i));
            }
        }
        return paginationList.toString();
    }

}
class QueryParser {
    private final String queryString;

    public QueryParser(String queryString) {
        this.queryString = queryString;
    }

    public Predicate<IPIR> getPredicate() {
        String[] andConditions = queryString.split("\\s+&&\\s+");
        Predicate<IPIR> predicate = ipir -> true;

        for (String andCondition : andConditions) {
            String[] orConditions = andCondition.split("\\s+\\|\\|\\s+");
            Predicate<IPIR> orPredicate = ipir -> false;

            for (String orCondition : orConditions) {
                String[] parts = orCondition.split("\\s+", 2);
                String attribute = parts[0];
                parts = parts[1].split("\\s+", 2);
                String operator = parts[0];
                String value = parts[1];

                switch (attribute) {
                    case "name":
                        orPredicate = orPredicate.or(ipir -> ipir instanceof Contact && evaluateStringCondition(((Contact) ipir).getName(), operator, value));
                        break;
                    case "address":
                        orPredicate = orPredicate.or(ipir -> ipir instanceof Contact && evaluateStringCondition(((Contact) ipir).getAddress(), operator, value));
                        break;
                    case "phone":
                        orPredicate = orPredicate.or(ipir -> ipir instanceof Contact && evaluateStringCondition(((Contact) ipir).getPhone(), operator, value));
                        break;
                    case "description":
                        orPredicate = orPredicate.or(ipir -> {
                            if (ipir instanceof Event) {
                                return evaluateStringCondition(((Event) ipir).getDescription(), operator, value);
                            } else if (ipir instanceof Task) {
                                return evaluateStringCondition(((Task) ipir).getDescription(), operator, value);
                            } else {
                                return false;
                            }
                        });
                        break;
                    case "startTime":
                        orPredicate = orPredicate.or(ipir -> ipir instanceof Event && evaluateDateCondition(((Event) ipir).getStartTime(), operator, value));
                        break;
                    case "alarm":
                        orPredicate = orPredicate.or(ipir -> ipir instanceof Event && evaluateDateCondition(((Event) ipir).getAlarm(), operator, value));
                        break;
                    case "content":
                        orPredicate = orPredicate.or(ipir -> ipir instanceof Note && evaluateStringCondition(((Note) ipir).getContent(), operator, value));
                        break;
                    case "deadline":
                        orPredicate = orPredicate.or(ipir -> ipir instanceof Task && evaluateDateCondition(((Task) ipir).getDeadline(), operator, value));
                        break;
                }
            }

            predicate = predicate.and(orPredicate);
        }

        return predicate;
    }

    private boolean evaluateStringCondition(String actualValue, String operator, String expectedValue) {
        switch (operator) {
            case "==":
                return actualValue.equals(expectedValue);
            case "contains":
                return actualValue.contains(expectedValue);
            default:
                return false;
        }
    }

    private boolean evaluateDateCondition(LocalDateTime actualDateTime, String operator, String expectedValue) {
        LocalDateTime expectedDateTime = stringToLocalDateTime(expectedValue);

        switch (operator) {
            case ">":
                return actualDateTime.isAfter(expectedDateTime);
            case "<":
                return actualDateTime.isBefore(expectedDateTime);
            case "==":
                return actualDateTime.isEqual(expectedDateTime);
            default:
                return false;
        }
    }
    private boolean evaluateDateCondition(Date actualValue, String operator, String expectedValue) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate expectedDate = LocalDate.parse(expectedValue, formatter);
        LocalDate actualDate = actualValue.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        switch (operator) {
            case ">":
                return actualDate.isAfter(expectedDate);
            case "<":
                return actualDate.isBefore(expectedDate);
            case "==":
                return actualDate.isEqual(expectedDate);
            default:
                return false;
        }
    }
}