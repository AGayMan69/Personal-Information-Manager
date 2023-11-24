package se.pim.command.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.pim.model.IPIR;
import se.pim.model.impl.Event;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static se.pim.Const.importPIR;
import static se.pim.Const.stringToLocalDateTime;

class ListPIRCommandTest {
    private Map<Integer, IPIR> pirs;

    String searchString = "startTime > 2023/05/01 08:00 && startTime < 2023/05/01 23:59";
    int page = 1;

    ViewPIRCommand viewPIRCommand;
    @BeforeEach
    void setUp() {
        pirs = new HashMap<>();
        importPIR("default", pirs);
        viewPIRCommand = new ViewPIRCommand(pirs);
    }


    @Test
    void searchPirList() {
        Map<Integer, IPIR> filteredPIRS = new ListPIRCommand(pirs, searchString, page, viewPIRCommand).searchPirList(searchString);
        Map.Entry<Integer, IPIR> entry = filteredPIRS.entrySet().iterator().next();
        IPIR pir = entry.getValue();
        assertAll(
                () -> assertTrue(((Event) pir).getStartTime().isBefore(stringToLocalDateTime("2023/05/01 23:59"))),
                () -> assertTrue(((Event) pir).getStartTime().isAfter(stringToLocalDateTime("2023/05/01 08:00")))
        );
    }
}