package theorie.interfaces;

import java.awt.*;

public class BathroomDoor implements Door {
    Color occupiedIndicatorColor = Color.GREEN;
    String doorStatus = "CLOSED";

    public void open() {
        if (doorStatus.equals("LOCKED")) {
            System.out.println("Door is locked, unlocking first...");
            unlock();
        }
        doorStatus = "OPEN";
        occupiedIndicatorColor = Color.BLUE;
        System.out.println("Door is now open! Indicator = BLUE");
    }

    public void close() {
        if (!doorStatus.equals("OPEN")) {
            System.out.println("Can only close an open door!");
            return;
        }
        doorStatus = "CLOSED";
        occupiedIndicatorColor = Color.GREEN;
        System.out.println("Door is now closed! Indicator = GREEN");
    }

    public void lock() {
        if (doorStatus.equals("OPEN")) {
            System.out.println("Closing door");
            close();
        }
        doorStatus = "LOCKED";
        occupiedIndicatorColor = Color.RED;
        System.out.println("Door is now locked! Indicator = RED");
    }

    public void unlock() {
        if (doorStatus.equals("LOCKED")) {
            System.out.println("Unlocking door");
            doorStatus = "CLOSED";
            occupiedIndicatorColor = Color.GREEN;
            System.out.println("Door is now unlocked! Indicator = GREEN");
        }
        else {
            System.out.println("The door is already unlocked!");
        }
    }
}