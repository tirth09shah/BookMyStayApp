/**
 * Use Case 4: Room Search & Availability Check
 *
 * Demonstrates read-only access to inventory and filtering
 * of available rooms without modifying system state.
 *
 * @author Tirth
 * @version 4.0
 */

import java.util.HashMap;

// Inventory Class (same concept from UC3)
class RoomInventory {

    private HashMap<String, Integer> inventory;

    public RoomInventory() {
        inventory = new HashMap<>();
    }

    public void addRoom(String roomType, int count) {
        inventory.put(roomType, count);
    }

    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }

    public HashMap<String, Integer> getAllRooms() {
        return inventory;
    }
}

// Room class (domain model)
class Room {

    private String roomType;
    private double price;

    public Room(String roomType, double price) {
        this.roomType = roomType;
        this.price = price;
    }

    public String getRoomType() {
        return roomType;
    }

    public double getPrice() {
        return price;
    }

    public void displayDetails() {
        System.out.println("Room Type : " + roomType);
        System.out.println("Price     : $" + price);
    }
}

// Search Service (read-only logic)
class RoomSearchService {

    public void searchAvailableRooms(RoomInventory inventory, Room[] rooms) {

        System.out.println("===== Available Rooms =====\n");

        for (Room room : rooms) {
            int available = inventory.getAvailability(room.getRoomType());

            // Show only available rooms
            if (available > 0) {
                room.displayDetails();
                System.out.println("Available : " + available);
                System.out.println();
            }
        }
    }
}

public class UseCase4RoomSearch {

    public static void main(String[] args) {

        // Setup inventory (state)
        RoomInventory inventory = new RoomInventory();
        inventory.addRoom("Single Room", 5);
        inventory.addRoom("Double Room", 0); // Not available
        inventory.addRoom("Suite Room", 2);

        // Room objects (domain)
        Room[] rooms = {
                new Room("Single Room", 100.0),
                new Room("Double Room", 180.0),
                new Room("Suite Room", 300.0)
        };

        // Search service
        RoomSearchService searchService = new RoomSearchService();

        // Perform search (READ ONLY)
        searchService.searchAvailableRooms(inventory, rooms);
    }
}