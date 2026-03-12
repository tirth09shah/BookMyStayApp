import java.util.List;

/**
 * RoomSearchService
 *
 * Handles read-only search operations for available rooms.
 * This class retrieves availability from RoomInventory and
 * displays only rooms that are currently available.
 *
 * @author Tirth
 * @version 4.1
 */

public class RoomSearchService {

    private RoomInventory inventory;

    public RoomSearchService(RoomInventory inventory) {
        this.inventory = inventory;
    }

    public void searchAvailableRooms(List<Room> rooms) {

        System.out.println("\nAvailable Rooms\n");

        for (Room room : rooms) {

            int available = inventory.getAvailability(room.getRoomType());

            // Defensive programming: show only available rooms
            if (available > 0) {

                room.displayRoomDetails();
                System.out.println("Available : " + available);
                System.out.println("-----------------------------");
            }
        }
    }
}