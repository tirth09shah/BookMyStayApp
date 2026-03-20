/**
 * Use Case 6: Reservation Confirmation & Room Allocation
 *
 * Demonstrates allocation using Queue (FIFO),
 * Set (unique room IDs), and HashMap (mapping rooms).
 *
 * @author Tirth
 * @version 6.0
 */

import java.util.*;

// Reservation (from UC5)
class Reservation {

    private String guestName;
    private String roomType;

    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRoomType() {
        return roomType;
    }
}

// Inventory (from UC3)
class RoomInventory {

    private HashMap<String, Integer> inventory = new HashMap<>();

    public void addRoom(String type, int count) {
        inventory.put(type, count);
    }

    public int getAvailability(String type) {
        return inventory.getOrDefault(type, 0);
    }

    public void reduceRoom(String type) {
        inventory.put(type, getAvailability(type) - 1);
    }
}

// Booking Service (Allocation logic)
class BookingService {

    private Set<String> allocatedRoomIds = new HashSet<>();
    private HashMap<String, Set<String>> roomAllocations = new HashMap<>();

    // Generate unique room ID
    private String generateRoomId(String roomType) {
        return roomType.substring(0, 2).toUpperCase() + "-" + (allocatedRoomIds.size() + 1);
    }

    // Process queue
    public void processBookings(Queue<Reservation> queue, RoomInventory inventory) {

        System.out.println("===== Processing Bookings =====\n");

        while (!queue.isEmpty()) {

            Reservation r = queue.poll();
            String type = r.getRoomType();

            // Check availability
            if (inventory.getAvailability(type) > 0) {

                String roomId = generateRoomId(type);

                // Ensure uniqueness
                while (allocatedRoomIds.contains(roomId)) {
                    roomId = generateRoomId(type);
                }

                allocatedRoomIds.add(roomId);

                // Map room type to allocated IDs
                roomAllocations.putIfAbsent(type, new HashSet<>());
                roomAllocations.get(type).add(roomId);

                // Update inventory
                inventory.reduceRoom(type);

                System.out.println("Booking Confirmed!");
                System.out.println("Guest : " + r.getGuestName());
                System.out.println("Room  : " + type);
                System.out.println("Room ID: " + roomId);
                System.out.println();

            } else {
                System.out.println("Booking Failed (No Availability)");
                System.out.println("Guest : " + r.getGuestName());
                System.out.println("Room  : " + type);
                System.out.println();
            }
        }
    }
}

public class UseCase6RoomAllocationService {

    public static void main(String[] args) {

        // Inventory setup
        RoomInventory inventory = new RoomInventory();
        inventory.addRoom("Single Room", 2);
        inventory.addRoom("Double Room", 1);

        // Booking queue (FIFO)
        Queue<Reservation> queue = new LinkedList<>();
        queue.offer(new Reservation("Alice", "Single Room"));
        queue.offer(new Reservation("Bob", "Single Room"));
        queue.offer(new Reservation("Charlie", "Single Room")); // should fail
        queue.offer(new Reservation("David", "Double Room"));

        // Process bookings
        BookingService service = new BookingService();
        service.processBookings(queue, inventory);
    }
}