package week3;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class GateController {
    public static void main(String[] args) {
        GateController gateController = new GateController();
        System.out.println(gateController.accessIsAllowed("FRONTGATE", "STOREOWNER", LocalDateTime.of(2024, 10, 7, 16, 0, 0)));
        System.out.println(gateController.accessIsAllowed("BACKGATE", "STOREOWNER", LocalDateTime.of(2024, 10, 7, 16, 0, 0)));
        System.out.println(gateController.accessIsAllowed("BACKGATE", "SECURITY", LocalDateTime.of(2024, 10, 6, 6, 0, 0)));
        System.out.println(gateController.accessIsAllowed("FRONTGATE", "EMPLOYEE", LocalDateTime.of(2024, 10, 18, 6, 0, 0)));
        System.out.println(gateController.accessIsAllowed("FRONTGATE", "EMPLOYEE", LocalDateTime.of(2024, 10, 20, 7, 0, 0)));
    }

    public boolean accessIsAllowed(String gateLocation, String badgeType, LocalDateTime timeOfDay) {
        if (gateLocation == null || badgeType == null || timeOfDay == null)
            throw new IllegalArgumentException("Arguments cannot be null");

        if (badgeType.equals("SECURITY")) return true;
        if (badgeType.equals("STOREOWNER")) {
            return !gateLocation.equals("BACKGATE");
        }

        if (!badgeType.equals("EMPLOYEE"))
            throw new IllegalArgumentException("Unknown badge type: " + badgeType);

        boolean isWeekday = timeOfDay.getDayOfWeek().getValue() < DayOfWeek.SATURDAY.getValue();
        boolean isWorkingHours = timeOfDay.getHour() >= 7 && timeOfDay.getHour() <= 19;

        return gateLocation.equals("FRONTGATE") && isWeekday && isWorkingHours;
    }
}