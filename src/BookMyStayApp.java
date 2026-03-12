import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * RoomAllocationService
 *
 * Processes booking requests and allocates rooms safely.
 * Prevents duplicate room allocation using a Set.
 *
 * @author Tirth
 * @version 6.0
 */

public class RoomAllocationService {

    private RoomInventory inventory;
    private Map<String, Set<String>> allocatedRooms;
    private int roomCounter = 1;

    public RoomAllocationService(RoomInventory inventory) {
        this.inventory = inventory;
        allocatedRooms = new HashMap<>();
    }

    public void processBookings(Queue<Reservation> bookingQueue) {

        System.out.println("\nProcessing Booking Requests...\n");

        while (!bookingQueue.isEmpty()) {

            Reservation request = bookingQueue.poll();
            String roomType = request.getRoomType();

            int available = inventory.getAvailability(roomType);

            if (available > 0) {

                // Generate unique room ID
                String roomId = roomType.replace(" ", "") + "-" + roomCounter++;

                // Store allocated room ID
                allocatedRooms
                        .computeIfAbsent(roomType, k -> new HashSet<>())
                        .add(roomId);

                // Update inventory
                inventory.updateAvailability(roomType, available - 1);

                System.out.println("Reservation Confirmed for "
                        + request.getGuestName());
                System.out.println("Room Type: " + roomType);
                System.out.println("Assigned Room ID: " + roomId);
                System.out.println("--------------------------------");

            } else {

                System.out.println("Reservation Failed for "
                        + request.getGuestName());
                System.out.println("No rooms available for: " + roomType);
                System.out.println("--------------------------------");
            }
        }
    }
}