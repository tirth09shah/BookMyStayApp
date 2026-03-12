import java.util.ArrayList;
import java.util.List;

/**
 * BookingHistory
 *
 * Stores confirmed reservations in insertion order.
 *
 * @author Tirth
 * @version 8.0
 */

public class BookingHistory {

    private List<Reservation> bookingList;

    public BookingHistory() {
        bookingList = new ArrayList<>();
    }

    // Add confirmed reservation
    public void addReservation(Reservation reservation) {
        bookingList.add(reservation);
        System.out.println("Reservation stored in history for "
                + reservation.getGuestName());
    }

    // Retrieve booking history
    public List<Reservation> getAllReservations() {
        return bookingList;
    }
}