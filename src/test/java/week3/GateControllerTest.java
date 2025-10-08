package week3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class GateControllerTest {

    private final GateController gc = new GateController();

    @Test
    void securityAlwaysAllowed() {
        assertTrue(gc.accessIsAllowed("FRONTGATE", "SECURITY",
                LocalDateTime.of(2024,10,6,3,0))); // dimanche 03:00
        assertTrue(gc.accessIsAllowed("BACKGATE", "SECURITY",
                LocalDateTime.of(2024,10,7,12,0))); // lundi midi
    }

    @Test
    void storeOwnerFrontgateAllowed() {
        assertTrue(gc.accessIsAllowed("FRONTGATE", "STOREOWNER",
                LocalDateTime.of(2024,10,6,2,0))); // horaire/weekday sans importance
    }

    @Test
    void storeOwnerBackgateDenied() {
        assertFalse(gc.accessIsAllowed("BACKGATE", "STOREOWNER",
                LocalDateTime.of(2024,10,9,12,0)));
    }

    @Test
    void employeeFrontWeekdayWithinHoursAllowed() {
        assertTrue(gc.accessIsAllowed("FRONTGATE", "EMPLOYEE",
                LocalDateTime.of(2024,10,7,7,0)));  // lundi 07:00
        assertTrue(gc.accessIsAllowed("FRONTGATE", "EMPLOYEE",
                LocalDateTime.of(2024,10,8,19,0))); // mardi 19:00
    }

    @Test
    void employeeFrontBeforeHoursDenied() {
        assertFalse(gc.accessIsAllowed("FRONTGATE", "EMPLOYEE",
                LocalDateTime.of(2024,10,10,6,59))); // jeudi 06:59
    }

    @Test
    void employeeFrontWeekendDenied() {
        assertFalse(gc.accessIsAllowed("FRONTGATE", "EMPLOYEE",
                LocalDateTime.of(2024,10,6,10,0))); // dimanche
    }

    @Test
    void employeeBackgateDeniedEvenIfTimeOk() {
        assertFalse(gc.accessIsAllowed("BACKGATE", "EMPLOYEE",
                LocalDateTime.of(2024,10,7,10,0))); // lundi 10:00
    }

    @Test
    void unknownBadgeTypeThrows() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () ->
                gc.accessIsAllowed("FRONTGATE", "VISITOR",
                        LocalDateTime.of(2024,10,7,10,0)));
        assertTrue(ex.getMessage().contains("Unknown badge type"));
    }

    @Test
    void nullArgumentsThrow() {
        assertThrows(IllegalArgumentException.class, () ->
                gc.accessIsAllowed(null, "EMPLOYEE", LocalDateTime.now()));
        assertThrows(IllegalArgumentException.class, () ->
                gc.accessIsAllowed("FRONTGATE", null, LocalDateTime.now()));
        assertThrows(IllegalArgumentException.class, () ->
                gc.accessIsAllowed("FRONTGATE", "EMPLOYEE", null));
    }
}
