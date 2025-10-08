package week2;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CarMaintenaceTest {

    private CarMaintenance carMaintenance = new CarMaintenance();

    @Test
    void findCarsOneYearWithoutService() {
    }
    @Test
    void findCarsOneYearWithoutService_NullList_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> carMaintenance.findCarsOneYearWithoutService(null));
    }

    @Test
    void findCarsOneYearWithoutService_EmptyList_ReturnsEmptyMap() {
        assertEquals(Map.of(), carMaintenance.findCarsOneYearWithoutService(List.of()));
    }

    @Test
    void findCarsOneYearWithoutService_OnlyUniqueExpired_ReturnsMap() {
        assertEquals(Map.of(
                "1-ABC-123", LocalDate.of(2024, 1, 2),
                "2-DEF-456", LocalDate.of(2023, 3, 4),
                "3-GHI-789", LocalDate.of(2022, 5, 6)
        ), carMaintenance.findCarsOneYearWithoutService(List.of(
                "1-ABC-123,2024-01-02",
                "2-DEF-456,2023-03-04",
                "3-GHI-789,2022-05-06"
        )));
    }

    @Test
    void findCarsOneYearWithoutService_AllExpiredNonUnique_ReturnsMap() {
        assertEquals(Map.of(
                "2-DEF-456", LocalDate.of(2023, 3, 4),
                "1-ABC-123", LocalDate.of(2024, 1, 2)
        ), carMaintenance.findCarsOneYearWithoutService(List.of(
                "1-ABC-123,2022-05-06",
                "2-DEF-456,2023-03-04",
                "1-ABC-123,2024-01-02"
        )));
    }

    @Test
    void findCarsOneYearWithoutService_SomeExpiredNonUnique_ReturnsMap() {
        assertEquals(Map.of(
                "2-DEF-456", LocalDate.of(2023, 3, 4),
                "1-ABC-123", LocalDate.of(2024, 1, 2)
        ), carMaintenance.findCarsOneYearWithoutService(List.of(
                "1-ABC-123,2022-05-06",
                "3-GHI-789,2024-01-02",
                "2-DEF-456,2023-03-04",
                "1-ABC-123,2024-01-02",
                "3-GHI-789," + LocalDate.now().minusYears(1).plusDays(1).toString()
        )));
    }
}