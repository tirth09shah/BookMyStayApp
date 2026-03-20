/**
 * Use Case 9: Error Handling & Validation
 *
 * Demonstrates input validation and custom exception handling.
 *
 * @author Tirth
 * @version 9.0
 */

import java.util.*;

// Custom Exception
class InvalidBookingException extends Exception {
    public InvalidBookingException(String message) {
        super(message);
    }
}

// Inventory class
class RoomInventory {

    private Map<String, Integer> inventory = new HashMap<>();

    public void addRoom(String type, int count) {
        inventory.put(type, count);
    }

    public int getAvailability(String type) {
        return inventory.getOrDefault(type, -1);
    }

    public void reduceRoom(String type) {
        inventory.put(type, getAvailability(type) - 1);
    }
}

// Validator
class BookingValidator {

    public void validate(String roomType, RoomInventory inventory) throws InvalidBookingException {

        if (inventory.getAvailability(roomType) == -1) {
            throw new InvalidBookingException("Invalid room type!");
        }

        if (inventory.getAvailability(roomType) <= 0) {
            throw new InvalidBookingException("No rooms available!");
        }
    }
}

public class UseCase9ErrorHandlingValidation {

    public static void main(String[] args) {

        RoomInventory inventory = new RoomInventory();
        inventory.addRoom("Single Room", 1);

        BookingValidator validator = new BookingValidator();

        String requestedRoom = "Single Room";

        try {
            validator.validate(requestedRoom, inventory);

            inventory.reduceRoom(requestedRoom);

            System.out.println("Booking Successful for " + requestedRoom);

        } catch (InvalidBookingException e) {
            System.out.println("Booking Failed: " + e.getMessage());
        }
    }
}