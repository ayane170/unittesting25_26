package theorie.interfaces;

public class DoorUser {
    public static void main(String[] args) {
        Door door;
        door = new BankVaultDoor();
        door.open();
        door.close();
        door.lock();
        door.unlock();

        door = new BathroomDoor();
        door.open();
        door.close();
        door.lock();
        door.unlock();
    }
}
