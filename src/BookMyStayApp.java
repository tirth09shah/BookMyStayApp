/**
 * Use Case 10: Booking Cancellation & Inventory Rollback
 *
 * Demonstrates rollback using Stack (LIFO).
 *
 * @author Tirth
 * @version 10.0
 */

import java.util.*;

// Inventory
class RoomInventory {
    private Map<String, Integer> inventory = new HashMap<>();

    public void addRoom(String type, int count) {
        inventory.put(type, count);
    }

    public void increaseRoom(String type) {
        inventory.put(type, inventory.getOrDefault(type, 0) + 1);
    }

    public void display() {
        System.out.println("Inventory: " + inventory);
    }
}

// Cancellation Service
class CancellationService {

    private Stack<String> rollbackStack = new Stack<>();

    public void cancelBooking(String reservationId, String roomType, RoomInventory inventory) {

        System.out.println("Cancelling Reservation: " + reservationId);

        // Push to stack (track rollback)
        rollbackStack.push(reservationId);

        // Restore inventory
        inventory.increaseRoom(roomType);

        System.out.println("Cancellation successful. Inventory restored.");
    }
}

public class UseCase10BookingCancellation {

    public static void main(String[] args) {

        RoomInventory inventory = new RoomInventory();
        inventory.addRoom("Single Room", 1);

        CancellationService service = new CancellationService();

        // Cancel booking
        service.cancelBooking("RES-101", "Single Room", inventory);

        inventory.display();
    }
}