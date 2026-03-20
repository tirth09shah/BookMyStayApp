/**
 * Use Case 3: Centralized Room Inventory Management
 *
 * Demonstrates use of HashMap for centralized inventory handling.
 *
 * @author Tirth
 * @version 3.0
 */

import java.util.HashMap;

class RoomInventory {

    private HashMap<String, Integer> inventory;

    // Constructor initializes inventory
    public RoomInventory() {
        inventory = new HashMap<>();
    }

    // Add room type with count
    public void addRoom(String roomType, int count) {
        inventory.put(roomType, count);
    }

    // Get availability
    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }

    // Update availability
    public void updateAvailability(String roomType, int count) {
        inventory.put(roomType, count);
    }

    // Display full inventory
    public void displayInventory() {
        System.out.println("===== Room Inventory =====");
        for (String type : inventory.keySet()) {
            System.out.println(type + " Available: " + inventory.get(type));
        }
    }
}

public class UseCase3InventorySetup {

    public static void main(String[] args) {

        // Initialize inventory
        RoomInventory inventory = new RoomInventory();

        // Add room types
        inventory.addRoom("Single Room", 5);
        inventory.addRoom("Double Room", 3);
        inventory.addRoom("Suite Room", 2);

        // Display inventory
        inventory.displayInventory();

        System.out.println();

        // Example: Check availability
        System.out.println("Checking availability for Single Room: "
                + inventory.getAvailability("Single Room"));

        // Example: Update availability
        inventory.updateAvailability("Single Room", 4);

        System.out.println("After booking 1 Single Room:");
        inventory.displayInventory();
    }
}