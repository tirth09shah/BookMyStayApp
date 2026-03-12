/**
 * Use Case 9: Error Handling & Validation
 *
 * Demonstrates validation and safe error handling.
 *
 * @author Tirth
 * @version 9.0
 */

public class UseCase9ErrorHandlingValidation {

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println(" Book My Stay - Hotel System");
        System.out.println(" Version 9.0");
        System.out.println("=================================");

        SafeInventoryService inventory = new SafeInventoryService();

        Reservation r1 = new Reservation("Alice", "Single Room");
        Reservation r2 = new Reservation("", "Double Room");   // Invalid name
        Reservation r3 = new Reservation("Bob", "Penthouse");  // Invalid room

        processReservation(r1, inventory);
        processReservation(r2, inventory);
        processReservation(r3, inventory);
    }

    public static void processReservation(
            Reservation reservation,
            SafeInventoryService inventory) {

        try {

            InvalidBookingValidator.validateReservation(reservation);

            System.out.println("\nProcessing booking for "
                    + reservation.getGuestName());

            inventory.allocateRoom(reservation.getRoomType());

        } catch (InvalidBookingException e) {

            System.out.println("\nBooking Failed:");
            System.out.println(e.getMessage());
        }
    }
}