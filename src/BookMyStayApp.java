/**
 * Use Case 8: Booking History & Reporting
 *
 * Demonstrates storing confirmed bookings in a List
 * and generating simple reports.
 *
 * @author Tirth
 * @version 8.0
 */

import java.util.*;

// Reservation class
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
        System.out.println("Guest: " + guestName + ", Room: " + roomType);
    }
}

// Booking History
class BookingHistory {

    private List<Reservation> history = new ArrayList<>();

    public void addReservation(Reservation r) {
        history.add(r);
    }

    public List<Reservation> getAll() {
        return history;
    }
}

// Report Service
class ReportService {

    public void generateReport(List<Reservation> history) {

        System.out.println("===== Booking Report =====");

        for (Reservation r : history) {
            r.display();
        }

        System.out.println("Total Bookings: " + history.size());
    }
}

public class UseCase8BookingHistoryReport {

    public static void main(String[] args) {

        BookingHistory history = new BookingHistory();

        history.addReservation(new Reservation("Alice", "Single Room"));
        history.addReservation(new Reservation("Bob", "Double Room"));
        history.addReservation(new Reservation("Charlie", "Suite Room"));

        ReportService report = new ReportService();
        report.generateReport(history.getAll());
    }
}