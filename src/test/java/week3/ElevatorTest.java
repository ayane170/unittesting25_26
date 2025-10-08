package week3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ElevatorTest {

    @Test
    void staff_AllFloorsExceptCurrent() {
        Elevator e = new Elevator();
        int[] result = e.activeButtons("S", 3);
        assertArrayEquals(new int[]{-2, -1, 0, 1, 2, 4, 5, 6, 7, 8, 9, 10}, result);
    }

    @Test
    void staff_LowercaseS_WorksToo() {
        Elevator e = new Elevator();
        int[] result = e.activeButtons("s", -2);
        assertArrayEquals(new int[]{-1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, result);
    }

    @Test
    void guest405_OnRoomFloor_CurrentButtonRemoved() {
        Elevator e = new Elevator();
        int[] result = e.activeButtons("405", 4);
        assertArrayEquals(new int[]{0, 10}, result);
    }

    @Test
    void guest405_OnLobby_CurrentButtonRemoved() {
        Elevator e = new Elevator();
        int[] result = e.activeButtons("405", 0);
        assertArrayEquals(new int[]{4, 10}, result);
    }

    @Test
    void guest405_OnRestaurant_CurrentButtonRemoved() {
        Elevator e = new Elevator();
        int[] result = e.activeButtons("405", 10);
        assertArrayEquals(new int[]{0, 4}, result);
    }

    @Test
    void guest405_OnMinus1_Alarm() {
        Elevator e = new Elevator();
        assertThrows(IllegalStateException.class, () -> e.activeButtons("405", -1));
    }

    @Test
    void nullBadge_NotAllowed() {
        Elevator e = new Elevator();
        assertThrows(IllegalArgumentException.class, () -> e.activeButtons(null, 0));
    }

    @Test
    void nonDigitBadge_FirstCharInvalid() {
        Elevator e = new Elevator();
        assertThrows(IllegalArgumentException.class, () -> e.activeButtons("A05", 0));
    }

    @Test
    void roomFloorZero_Invalid() {
        Elevator e = new Elevator();
        assertThrows(IllegalArgumentException.class, () -> e.activeButtons("005", 0));
    }

    @Test
    void currentLevelOutOfRange_Invalid() {
        Elevator e = new Elevator();
        assertThrows(IllegalArgumentException.class, () -> e.activeButtons("405", 11));
    }
}
