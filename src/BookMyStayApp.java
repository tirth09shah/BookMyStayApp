/**
 * Use Case 5: Booking Request (First-Come-First-Served)
 *
 * Demonstrates use of Queue to handle booking requests
 * in FIFO order without modifying inventory.
 *
 * @author Tirth
 * @version 5.0
 */

import java.util.LinkedList;
import java.util.Queue;

// Reservation class (represents booking request)
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

    public void display() {
        System.out.println("Guest Name : " + guestName);
        System.out.println("Room Type  : " + roomType);
    }
}

// Booking Queue (FIFO structure)
class BookingQueue {

    private Queue<Reservation> queue;

    public BookingQueue() {
        queue = new LinkedList<>();
    }

    // Add request
    public void addRequest(Reservation reservation) {
        queue.offer(reservation);
    }

    // View all requests
    public void displayQueue() {
        System.out.println("===== Booking Requests (FIFO Order) =====\n");

        for (Reservation r : queue) {
            r.display();
            System.out.println();
        }
    }
}

public class UseCase5BookingQueue {

    public static void main(String[] args) {

        // Initialize booking queue
        BookingQueue bookingQueue = new BookingQueue();

        // Add booking requests (FIFO order)
        bookingQueue.addRequest(new Reservation("Alice", "Single Room"));
        bookingQueue.addRequest(new Reservation("Bob", "Double Room"));
        bookingQueue.addRequest(new Reservation("Charlie", "Suite Room"));

        // Display queue (NO allocation yet)
        bookingQueue.displayQueue();
    }
}