package theorie.interfaces;

public class BankVaultDoor implements Door {
    DoorSensor doorSensor = new DoorSensor();
    MotorController motorController = new MotorController();
    LockController lockController = new LockController();

    @Override
    public void open() {
        System.out.println("Attempting to open the door");
        if (lockController.isLocked()) {
            System.out.println("The door is locked!");
            return;
        }

        while (!doorSensor.doorIsFullyOpened()) {
            System.out.println("Opening the door...");
            motorController.pull();
        }
        System.out.println("The door is open!");
    }

    @Override
    public void close() {
        System.out.println("Attempting to close the door");

        while (!doorSensor.doorIsFullyClosed()) {
            System.out.println("Closing the door...");
            motorController.push();
        }

        System.out.println("The door is closed");
    }

    @Override
    public void lock() {
        if (doorSensor.isFullyClosed() && !lockController.isLocked()) {
            System.out.println("Locking the door");
            lockController.lock();
        }
        else {
            System.out.println("The door is still open or already locked!");
        }
    }

    @Override
    public void unlock() {
        if (lockController.isLocked()) {
            System.out.println("Unlocking the door");
            lockController.unlock();
        }
        else {
            System.out.println("The door is already unlocked!");
        }
    }
}

class DoorSensor {
    public boolean doorIsFullyOpened() {
        // Simulate checking if the door is fully opened
        return true;
    }

    public boolean doorIsFullyClosed() {
        // Simulate checking if the door is fully closed
        return true;
    }

    public boolean isFullyClosed() {
        // Simulate checking if the door is fully closed
        return true;
    }
}

class MotorController {
    public void pull() {
        System.out.println("Motor pulling");
        // Simulate pulling the motor
    }

    public void push() {
        System.out.println("Motor pushing");
        // Simulate pushing the motor
    }
}

class LockController {
    private boolean locked = false;

    public void lock() {
        locked = true;
    }

    public void unlock() {
        locked = false;
    }

    public boolean isLocked() {
        return locked;
    }
}